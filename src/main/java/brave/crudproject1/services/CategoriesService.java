package brave.crudproject1.services;

import brave.crudproject1.entities.Categories;
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

    public 




}
