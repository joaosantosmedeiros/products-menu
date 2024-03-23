package dev.jota.foodmenu.infra.db.schema;

import dev.jota.foodmenu.entity.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
public class ProductEntity {

    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Boolean isDisponible;

    public Product toProduct() {
        return new Product(
                this.id,
                this.name,
                this.description,
                this.price,
                this.isDisponible
        );
    }
}
