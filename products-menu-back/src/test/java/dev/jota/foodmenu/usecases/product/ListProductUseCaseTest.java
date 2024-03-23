package dev.jota.foodmenu.usecases.product;

import dev.jota.foodmenu.entity.gateway.ProductGateway;
import dev.jota.foodmenu.entity.model.FetchedProduct;
import dev.jota.foodmenu.entity.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ListProductUseCaseTest {

    @Mock
    private ProductGateway productGateway;

    @InjectMocks
    @Autowired
    private ListProductUseCase listProductUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("It should list products correctly")
    void listProductSuccess() {
        List<Product> productList = List.of(
                new Product("p1", "p1", 5d, true),
                new Product("p2", "p2", 4.5d, false),
                new Product("p4", "p4", 6d, false),
                new Product("p5", "p2", 4d, true),
                new Product("p6", "p6", 3d, false)
        );

        when(productGateway.list()).thenReturn(productList);

        var sortedFetchedProducts = productList.stream()
                .map(FetchedProduct::new)
                .sorted(Comparator.comparing(FetchedProduct::getPrice))
                .toList();

        var output = listProductUseCase.execute().data();

        for (int i = 0; i < productList.size(); i++) {
            assertEquals(output.get(i), sortedFetchedProducts.get(i));
        }

    }
}