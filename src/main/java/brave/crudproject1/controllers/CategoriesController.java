package brave.crudproject1.controllers;


import brave.crudproject1.dto.CategoriesDTO;
import brave.crudproject1.dto.CustomerDTO;
import brave.crudproject1.entities.Categories;
import brave.crudproject1.entities.Customer;
import brave.crudproject1.services.CategoriesService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public List<Categories>getAllCategories() {
        return categoriesService.getAllCategories();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoriesById(@PathVariable Long id){
        Categories categories = categoriesService.getCategoriesById(id);
        return ResponseEntity.ok(categories); //ResponseEntity.ok(categories); başarılı bir işlem sonucunda categories adlı nesneyi (örneğin, bir kategori listesini) geri döndürmek için kullanılır ve bu işlemde HTTP yanıt kodu olarak 200 OK belirtilir.
    }
    @PostMapping
    public Categories createCategory(@RequestBody CategoriesDTO categoriesDTO){
        return categoriesService.createCategories(categoriesDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategories(
            @PathVariable Long id,
            @RequestBody CategoriesDTO categoriesDTO){
        Categories updatedCategories = categoriesService.updateCategories(id, categoriesDTO);
        return ResponseEntity.ok(updatedCategories);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategories(id);
        return ResponseEntity.noContent().build(); /*Bu, HTTP yanıtı için 204 No Content durum kodunu oluşturur. Bu kod, isteğin başarıyla işlendiğini fakat yanıt gövdesinde herhangi bir içerik bulunmadığını belirtir.
    build(): Yanıtı sonlandırıp ResponseEntity nesnesini oluşturur. Yani bu metot, HTTP yanıtını tam olarak şekillendirip istemciye gönderilmesini sağlar.*/
    }


}
