package dev.jota.foodmenu.infra.controllers;

import dev.jota.foodmenu.entity.model.FetchedProduct;
import dev.jota.foodmenu.usecases.product.ListProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ListProductsController {

    private ListProductUseCase listProductUseCase;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product")
    public ResponseEntity<Response> listProducts() {

        var output = listProductUseCase.execute();

        return  ResponseEntity.ok(new Response(
                true,
                "Success",
                output.data()
        ));
    }

    public record Response(
            Boolean status,
            String message,
            List<FetchedProduct> data
    ) {}
}
