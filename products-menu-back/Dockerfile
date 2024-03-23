FROM openjdk:17-alpine

WORKDIR /app
COPY ./products-menu-back/target/products-menu-back-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "products-menu-back-0.0.1-SNAPSHOT.jar"]
