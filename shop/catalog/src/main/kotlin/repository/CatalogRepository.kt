package shop.catalog.main.repository;

import org.springframework.data.jpa.repository.JpaRepository
import shop.catalog.main.entity.Catalog

interface CatalogRepository : JpaRepository<Catalog, Long> {
    fun findByProductId(productId : String) : Catalog?
}