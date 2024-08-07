
# Algorithm

## List
- [hash](hash)
  - [hash.java](hash/hash.java)
  - [README.md](hash/README.md)











Requirements:
Function:
track by location
pricing mechanism
match drivers and passengers


non-functionL:
route optimization and eta calculation
data storage for trip
high demand and reliability

Key:
api gateway: handling request
drivers match passengers with same order, driver can see all passengers orders
database: trip history
cache: to reduce request and database load
analytics service: surge pricing mechanism, track high demand and reliability
Queue: for driver recevie request 
CDN: to storage drivers

Design High Level Architecture

          Passengers make orders
          Load Balancer
API                         API
1                           2
drivers                     drivers
service to decide confirm order
database to store this order            cache to storage some drivers
analytics service



database schema: 



Scability
1m requset/day

1 / 

throughput

