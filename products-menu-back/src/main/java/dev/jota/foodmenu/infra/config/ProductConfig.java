package dev.jota.foodmenu.infra.config;

import dev.jota.foodmenu.entity.gateway.ProductGateway;
import dev.jota.foodmenu.usecases.product.CreateProductUseCase;
import dev.jota.foodmenu.usecases.product.ListProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway){
        return new CreateProductUseCase(productGateway);
    }

    @Bean
    public ListProductUseCase listProductUseCase(ProductGateway productGateway){
        return new ListProductUseCase(productGateway);
    }
}
