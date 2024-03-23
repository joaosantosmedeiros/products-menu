package dev.jota.foodmenu.entity.model;

import java.util.Objects;

public class FetchedProduct {
    private final String nome;
    private final Double price;

    public FetchedProduct(Product product){
        this.nome = product.getName();
        this.price = product.getPrice();
    }

    public String getNome() {
        return nome;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FetchedProduct that = (FetchedProduct) o;
        return Objects.equals(nome, that.nome) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, price);
    }
}
