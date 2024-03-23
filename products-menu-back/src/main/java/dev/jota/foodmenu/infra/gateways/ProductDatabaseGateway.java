package dev.jota.foodmenu.infra.gateways;

import dev.jota.foodmenu.entity.gateway.ProductGateway;
import dev.jota.foodmenu.entity.model.Product;
import dev.jota.foodmenu.infra.db.repository.ProductRepository;
import dev.jota.foodmenu.infra.db.schema.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProductDatabaseGateway implements ProductGateway {

    private ProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.findAll().stream().map(productEntity -> productEntity.toProduct()
        ).collect(Collectors.toList());
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = new ProductEntity(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getDisponible()
        );
        return productRepository.save(productEntity).toProduct();
    }
}
