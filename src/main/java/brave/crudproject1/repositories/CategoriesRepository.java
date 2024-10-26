package brave.crudproject1.repositories;

import brave.crudproject1.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {

}
