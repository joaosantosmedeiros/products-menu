package dev.jota.foodmenu.usecases.product;

import dev.jota.foodmenu.entity.gateway.ProductGateway;
import dev.jota.foodmenu.entity.model.Product;

public class CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductUseCase(ProductGateway productGateway){
        this.productGateway = productGateway;
    }

    public Output execute(Input input) {
        Product product = productGateway.create(new Product(
                input.name,
                input.description,
                input.price,
                input.isDisponible
        ));

        return new Output(productGateway.create(product));
    }

    public record Input(
        String name,
        String description,
        Double price,
        Boolean isDisponible
    ){}

    public record Output(Product data){}
}
