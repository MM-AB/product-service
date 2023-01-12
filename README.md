# Product microservice

## Prerequisites

Create network **rsonetwork** if there is none:

```bash
docker network create rsonetwork
```

Install MongoDB and start MongoDB server with:
```bash
mongod
```

Clean install Maven package:
```bash
mvn clean install
```


## Build and run Docker containers

Building **productservice** container:
```bash
docker build -t productservice .
```

Run mongo:
```bash
docker run --name=mongo --rm --network=rsonetwork mongo
```

Run app:
```bash
docker run --name=productservice --rm --network=rsonetwork -p 8080:8080 -e MONGO_PRODUCT_URL=MONGO_URL=mongodb://mongo:27017/products productservice
```

## Rename Docker image and push to repository

Rename image:
```bash
docker tag productservice rsoreg.azurecr.io/product-service:**tag**
```

Push to repositorty:
```bash
docker push rsoreg.azurecr.io/product-service:**tag**
```
