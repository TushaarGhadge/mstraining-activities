# mstraining-activities
1. Config Server - This is spring cloud config server which contains application properties for all microservices. This is configurd with github repository config-repo
2. Eureka Naming Server - This is registry server where each service registers themselves and used by feign client 
3. currency exchange service - This contains 3 web services to add, modify and get conversion factor for the particular country
4. currency conversion service - this is main service used to get converted currency amount which internally calls currency exchange service to get conversion factor.
  * Feign client - is usd to communicate with other microservice to achieve dynamic calling and load balancing.
  * resilience4j - is used to implement circuit breaker pattern
  * zipkin distributed tracing - is implemented using sleuth ,rabbitmq and zipkin client

----
## URL's
| Application                       | Port                                                                    |
| ----------------------------------|:-----------------------------------------------------------------------:| 
| Config Server                     | http://localhost:8888                                                   | 
| Eureka Naming Server              | http://localhost:8761                                                   |
| Currency Exchange Service         | http://localhost:8000/currency-exchange/conversion-factor/USD           | 
| Currency Conversion Service       | http://localhost:8000//currency-converter/countryCode/USD/amount/1000   | 
| Zipkin                            | http://localhost:9411/zipkin/                                           |

----
## Ports
| Application                       | Port          |
| ----------------------------------|:-------------:| 
| Config Server                     | 8888          | 
| Eureka Naming Server              | 8761          | 
| Currency Exchange Service         | 8000          | 
| Currency Conversion Service       | 8100          |   
| Zipkin Distributed Tracing Server | 9411          | 

## Docker pull commands
Images are created and pused to docker hub registry

| Application                       | Pull ommand                                                  |
| ----------------------------------|:------------------------------------------------------------:| 
| Eureka Naming Server              | docker pull tusharghadge/eurka-naming-service:1.0.0          | 
| Currency Exchange Service         | docker pull tusharghadge/currency-exchange-service:1.0.0     | 
| Currency Conversion Service       | docker pull tusharghadge/currency-conversion-service:1.0.0   |
