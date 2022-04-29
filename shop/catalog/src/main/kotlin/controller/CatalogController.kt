package shop.catalog.main.controller

import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import shop.catalog.main.service.CatalogService
import shop.catalog.main.vo.ResponseCatalog
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/catalog-service/catalogs")
class CatalogController(val catalogService: CatalogService) {

    @GetMapping("/health-check")
    fun status(servletRequest: HttpServletRequest) : String = "It's Working in Catalog Service " + servletRequest.serverPort

    @GetMapping
    fun getCatalogs() : ResponseEntity<List<ResponseCatalog>> {
        val allCatalogs = catalogService.getAllCatalogs()

        val result =  mutableListOf<ResponseCatalog>()

        for (catalog in allCatalogs){
            result.add(ModelMapper().map(catalog, ResponseCatalog::class.java))
        }

        return ResponseEntity.status(HttpStatus.OK).body(result)
    }
}