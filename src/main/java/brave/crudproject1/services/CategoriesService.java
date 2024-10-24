package brave.crudproject1.services;

import brave.crudproject1.dto.CategoriesDTO;
import brave.crudproject1.dto.CustomerDTO;
import brave.crudproject1.entities.Categories;
import brave.crudproject1.entities.Customer;
import brave.crudproject1.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }

    public Categories getCategoriesById(Long id){
        return categoriesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
    }

    public Categories createCategories(CategoriesDTO categoriesDTO) {
        Categories categories = new Categories();
        categories.setCategoryName(categoriesDTO.getCategoryName());
        categories.setId(categoriesDTO.getId());

        return categoriesRepository.save(categories);

    }
    public Categories updateCategories(Long id,CategoriesDTO categoriesDTO){
        return categoriesRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Category not found"));
    }

    public void deleteCategories(Long id){
        if (!categoriesRepository.existsById(id)){
            throw new RuntimeException("Category not found");
        }
        categoriesRepository.deleteById(id);
    }






}
