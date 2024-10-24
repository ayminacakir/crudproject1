package brave.crudproject1.controllers;

import brave.crudproject1.dto.CategoriesDTO;
import brave.crudproject1.dto.SellersDTO;
import brave.crudproject1.entities.Categories;
import brave.crudproject1.entities.Sellers;
import brave.crudproject1.services.CategoriesService;
import brave.crudproject1.services.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellersController {
    @Autowired
    private SellersService sellersService;
    @GetMapping
    public List<Sellers> getAllSellers() {
        return sellersService.getAllSellers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sellers> getSellerById(@PathVariable Long id){
       Sellers sellers = sellersService.getSellerById(id);
        return ResponseEntity.ok(sellers);
    }
    @PostMapping
    public Sellers createSeller(@RequestBody SellersDTO sellersDTO){
        return sellersService.createSeller(sellersDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Sellers> updateSeller(
            @PathVariable Long id,
            @RequestBody SellersDTO sellersDTO){
        Sellers updatedSeller = sellersService.updateSeller(id, sellersDTO);
        return ResponseEntity.ok(updatedSeller);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellersService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}
