package dev.jota.foodmenu.usecases.product;

import dev.jota.foodmenu.entity.gateway.ProductGateway;
import dev.jota.foodmenu.entity.model.FetchedProduct;

import java.util.Comparator;
import java.util.List;

public class ListProductUseCase {

    private final ProductGateway productGateway;

    public ListProductUseCase(ProductGateway productGateway){
        this.productGateway = productGateway;
    }

    public Output execute() {
        List<FetchedProduct> productsList = productGateway.list()
                .stream()
                .map(FetchedProduct::new)
                .sorted(Comparator.comparing((FetchedProduct::getPrice)))
                .toList();

        return new Output(productsList);
    }

    public record Output (List<FetchedProduct> data) {}
}
