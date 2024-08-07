import java.util.*;

public class test2 {

    static class ConcertTicketBuyer {

        private class Requirement {
            Integer artistId;
            Integer maxPrice;
            Integer minSeats;
            
            public Requirement(Integer artistId, Integer maxPrice, Integer minSeats) {
                this.artistId = artistId;
                this.maxPrice = maxPrice;
                this.minSeats = minSeats;
            }
        }

        private class TicketInfo {
            Integer artistId;
            Integer price;
            Integer seats;
            boolean isComplete;
            boolean orderIssued;

            public TicketInfo() {
                this.isComplete = false;
                this.orderIssued = false;
            }
        }

        private Map<Integer, TicketInfo> tickets = new HashMap<>();
        private Queue<Requirement> requirements = new LinkedList<>();
        private Integer pendingOrderMessageId = null;
        private Integer pendingOrderSeats = null;

        public ConcertTicketBuyer() {
        }

        public void OnNewRequirement(Integer artistId, Integer ticketPrice, Integer availableSeats) {
            requirements.add(new Requirement(artistId, ticketPrice, availableSeats));
        }

        public Integer ProcessData(Integer messageId, Integer data) {
            if (messageId == 0) {
                if (pendingOrderMessageId != null) {
                    pendingOrderSeats = null;
                    pendingOrderMessageId = null;
                }
                return 0;
            }

            TicketInfo ticket = tickets.computeIfAbsent(messageId, k -> new TicketInfo());

            if (ticket.artistId == null) {
                ticket.artistId = data;
            } else if (ticket.price == null) {
                ticket.price = data;
            } else if (ticket.seats == null) {
                ticket.seats = data;
                ticket.isComplete = true;

                for (Requirement req : requirements) {
                    if (ticket.artistId.equals(req.artistId) &&
                        ticket.price <= req.maxPrice &&
                        ticket.seats >= req.minSeats) {
                        if (!ticket.orderIssued) {
                            pendingOrderMessageId = messageId;
                            pendingOrderSeats = req.minSeats;
                            ticket.orderIssued = true;
                        }
                        break;
                    }
                }
            }

            if (pendingOrderMessageId != null) {
                if (pendingOrderSeats != null) {
                    Integer orderMessageId = pendingOrderMessageId;
                    Integer orderSeats = pendingOrderSeats;
                    pendingOrderMessageId = null;
                    pendingOrderSeats = null;
                    return orderMessageId;
                }
            }

            return 0;
        }
    }
}
