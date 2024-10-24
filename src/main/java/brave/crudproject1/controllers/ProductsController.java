package brave.crudproject1.controllers;

import brave.crudproject1.dto.CategoriesDTO;
import brave.crudproject1.dto.ProductsDTO;
import brave.crudproject1.entities.Categories;
import brave.crudproject1.entities.Products;
import brave.crudproject1.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Products products = productsService.getProductById(id);
        return ResponseEntity.ok(products);
    }
    @PostMapping
    public Products createProducts(@RequestBody ProductsDTO productsDTO){
        return productsService.createProducts(productsDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductsDTO productsDTO){
        Products updateProducts = productsService.updateProduct(id, productsDTO);
        return ResponseEntity.ok(updateProducts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
