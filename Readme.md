# TDC Florianópolis 2024 - Dapr
## 13/06 - Florianópolis / SC

## Como o Dapr (Distributed Application Runtime) pode simplificar o desenvolvimento de aplicações em microservices

### Tecnologias
[![My Skills](https://skillicons.dev/icons?i=java,spring,linux,redis,azure)](https://skillicons.dev)

## Site Dapr.io
- [https://dapr.io/](https://dapr.io/)

### Diagrama de Microsserviços
![Diagrama](diagramas/diagrama.png "Diagrama")

### Slides
- [Download](slides/20240613-TDCFlorianopolis2024-Dapr_v2.pdf)

### Executar o projeto
```
mvn clean install -DskipTests
```

```
dapr run  -f .
```

### Swagger
- [ms_inventory Swagger](http://localhost:8081/swagger-ui/index.html)
- [ms_shoppingcart Swagger](http://localhost:8082/swagger-ui/index.html)
- [ms_checkout Swagger](http://localhost:8083/swagger-ui/index.html)
