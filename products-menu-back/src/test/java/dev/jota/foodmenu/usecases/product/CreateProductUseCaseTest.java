package dev.jota.foodmenu.usecases.product;

import dev.jota.foodmenu.entity.gateway.ProductGateway;
import dev.jota.foodmenu.entity.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateProductUseCaseTest {

    @Mock
    private ProductGateway productGateway;

    @Autowired
    @InjectMocks
    private CreateProductUseCase createProductUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProductSuccess() {
        var product = new Product("any_name", "any_description", 14.0, true);

        when(productGateway.create(any())).thenReturn(product);

        var output = createProductUseCase.execute(new CreateProductUseCase.Input(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getDisponible()
        ));

        assertNotNull(output.data());
    }
}