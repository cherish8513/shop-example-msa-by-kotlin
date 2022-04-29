package shop.catalog.main.service

import org.springframework.stereotype.Service
import shop.catalog.main.entity.Catalog
import shop.catalog.main.repository.CatalogRepository

@Service
class CatalogService(val catalogRepository: CatalogRepository) {

    fun getAllCatalogs() : Iterable<Catalog>{
        return catalogRepository.findAll();
    }
}