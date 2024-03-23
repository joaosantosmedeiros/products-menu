package dev.jota.foodmenu.entity.model;

import java.util.Objects;
import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Boolean isDisponible;

    public Product(String name, String description, Double price, Boolean isDisponible) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.isDisponible = isDisponible;
    }

    public Product(UUID id, String name, String description, Double price, Boolean isDisponible) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isDisponible = isDisponible;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getDisponible() {
        return isDisponible;
    }

    public void setDisponible(Boolean disponible) {
        isDisponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(isDisponible, product.isDisponible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, isDisponible);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isDisponible=" + isDisponible +
                '}';
    }
}
