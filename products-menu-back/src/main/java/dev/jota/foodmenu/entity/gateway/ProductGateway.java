package dev.jota.foodmenu.entity.gateway;

import dev.jota.foodmenu.entity.model.Product;

import java.util.List;

public interface ProductGateway {
    List<Product> list();
    Product create(Product product);
}
