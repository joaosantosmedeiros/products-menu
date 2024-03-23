package dev.jota.foodmenu.infra.db.repository;

import dev.jota.foodmenu.infra.db.schema.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
