import java.util.*;

import java.util.*;

public class test {

    static class SupermarketCheckout {
        private static class Customer {
            long customerId;
            long lineNumber;
            long numItems;

            Customer(long customerId, long lineNumber, long numItems) {
                this.customerId = customerId;
                this.lineNumber = lineNumber;
                this.numItems = numItems;
            }
        }

        private Map<Long, Queue<Customer>> lines;
        private Map<Long, Customer> customers;

        public SupermarketCheckout() {
            lines = new HashMap<>();
            customers = new HashMap<>();
        }

        public void onCustomerEnter(long customerId, long lineNumber, long numItems) {
            Customer customer = new Customer(customerId, lineNumber, numItems);
            System.out.println(
                    "Customer Enter: " + customer.customerId + " " + customer.lineNumber + " " + customer.numItems);
            customers.put(customerId, customer);
            lines.putIfAbsent(lineNumber, new LinkedList<>());
            lines.get(lineNumber).offer(customer);
        }

        public void onBasketChange(long customerId, long newNumItems) {
            Customer customer = customers.get(customerId);
            if (customer != null) {
                Queue<Customer> line = lines.get(customer.lineNumber);
                System.out.println("BasketChange for customer: " + customer.customerId + " from " + customer.numItems
                        + " to " + newNumItems);

                line.remove(customer);

                if (newNumItems == 0) {
                    customers.remove(customerId);
                    onCustomerExit(customerId);
                } else {
                    customer.numItems = newNumItems;
                    line.offer(customer);
                }

                System.out.println("Current state of lines after BasketChange for customer " + customerId
                        + " with new items " + newNumItems + ":");
                for (Map.Entry<Long, Queue<Customer>> entry : lines.entrySet()) {
                    System.out.print("Line " + entry.getKey() + ": ");
                    for (Customer c : entry.getValue()) {
                        System.out.print("[ID: " + c.customerId + ", Items: " + c.numItems + "] ");
                    }
                    System.out.println();
                }
            }
        }

        public void onLineService(long lineNumber, long numProcessedItems) {
            System.out.println("Current state of lines during LineService for line " + lineNumber + ":");
            for (Map.Entry<Long, Queue<Customer>> entry : lines.entrySet()) {
                System.out.print("Line " + entry.getKey() + ": ");
                for (Customer c : entry.getValue()) {
                    System.out.print("[ID: " + c.customerId + ", Items: " + c.numItems + "] ");
                }
                System.out.println();
            }

            Queue<Customer> line = lines.get(lineNumber);

            while (numProcessedItems > 0) {
                Customer customer = line.peek();

                System.out.println("Processing customer: " + customer.customerId + " with items: " + customer.numItems);
                if (customer.numItems <= numProcessedItems) {
                    numProcessedItems -= customer.numItems;
                    line.poll();
                    customers.remove(customer.customerId);
                    onCustomerExit(customer.customerId);
                } else {
                    System.out.println("WWWWWWWW" + customer.numItems + numProcessedItems);
                    customer.numItems -= numProcessedItems;
                    numProcessedItems = 0;
                }

                System.out.println("Current Customer " +
                        lineNumber + ":");
                for (Map.Entry<Long, Customer> entry : customers.entrySet()) {
                    System.out.print("Line " + entry.getKey() + ": " + entry.getValue().numItems);
                    System.out.println();
                }
            }
            
        }

        public void onLinesService() {
            List<Long> lineKeys = new ArrayList<>(lines.keySet());
            Collections.sort(lineKeys);
            for (long lineNumber : lineKeys) {
                onLineService(lineNumber, 1);
            }
        }

        private void onCustomerExit(long customerId) {
            // Don't change this implementation.
            System.out.println(customerId);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        scanner.nextLine();

        SupermarketCheckout checkoutTracker = new SupermarketCheckout();
        for (long i = 0; i < N; ++i) {
            String[] instruction = scanner.nextLine().split(" ");
            String instructionType = instruction[0];

            if (instructionType.equals("CustomerEnter")) {
                long customerId = Long.parseLong(instruction[1]);
                long lineNumber = Long.parseLong(instruction[2]);
                long numItems = Long.parseLong(instruction[3]);
                checkoutTracker.onCustomerEnter(customerId, lineNumber, numItems);
            } else if (instructionType.equals("BasketChange")) {
                long customerId = Long.parseLong(instruction[1]);
                long newNumItems = Long.parseLong(instruction[2]);
                checkoutTracker.onBasketChange(customerId, newNumItems);
            } else if (instructionType.equals("LineService")) {
                long lineNumber = Long.parseLong(instruction[1]);
                long numProcessedItems = Long.parseLong(instruction[2]);
                checkoutTracker.onLineService(lineNumber, numProcessedItems);
            } else if (instructionType.equals("LinesService")) {
                checkoutTracker.onLinesService();
            } else {
                System.out.println("Malformed input!");
                System.exit(-1);
            }
        }
    }
}

// javac test.java
// Get-Content input.txt | java test
