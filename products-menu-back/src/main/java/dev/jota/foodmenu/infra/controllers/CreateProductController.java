package dev.jota.foodmenu.infra.controllers;

import dev.jota.foodmenu.entity.model.Product;
import dev.jota.foodmenu.usecases.product.CreateProductUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CreateProductController {

    private CreateProductUseCase createProductUseCase;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/product")
    public ResponseEntity<Response> createProduct(@RequestBody @Valid Request request) {

        var output = createProductUseCase.execute(new CreateProductUseCase.Input(
                request.name,
                request.description,
                request.price,
                request.isDisponible
        ));

        return ResponseEntity.status(HttpStatus.CREATED).body(new Response(
                true,
                "Product created successfully",
                output.data()
        ));
    }

    public record Request(
            @NotBlank
            String name,
            @NotBlank
            String description,
            @Positive
            Double price,
            @NotNull
            Boolean isDisponible
    ){}
    public record Response(
        Boolean status,
        String message,
        Product data
    ){}
}
