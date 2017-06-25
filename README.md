# Spring-Boot-Consul-Zuul-Ribbon-POC

## Stack Used

1. Spring Boot
2. Netflix - Zuul(Routing and Filtering), Ribbon (Load Balancer)
3. Consul (Service Discovery)

## Setup Required

1. Conusl server
    a. Download and Install from <a href="https://consul.io">consul.io</a>
    b. Add consul home directory in path.
    c. Run consul agent as a server (consul agent -server -bootstrap -data-dir=/consul-data -ui)
    
2. Maven - Download and Install maven
