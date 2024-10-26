package brave.crudproject1.repositories;

import brave.crudproject1.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    boolean existsByCategoryName(String categoryName);

    Optional<Products> findById(Long productId); /*Optional, değerlerin olup olmadığını kontrol etmenizi sağlar. Bu, null kontrollerini daha yönetilebilir hale getirir.
    Optional<Product> findById(Long productId); ifadesi, veritabanında belirli bir ürün aramak için kullanılan, null güvenliğini sağlamak amacıyla tasarlanmış bir metot tanımıdır.*/
    int findStockQuantityById(Long productId);
}
