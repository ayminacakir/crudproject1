package brave.crudproject1.services;

import brave.crudproject1.dto.CategoriesDTO;
import brave.crudproject1.dto.ProductsDTO;
import brave.crudproject1.entities.Categories;
import brave.crudproject1.entities.Products;
import brave.crudproject1.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Products>getAllProducts(){
        return productsRepository.findAll();
    }
    public Products getProductById(Long id){
        return productsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
    }
    public Products createProducts(ProductsDTO productsDTO){
        Products products = new Products();
        products.setProductName(productsDTO.getProductName());
        products.setCategoryName(productsDTO.getCategoryName());
        products.setSellerName(productsDTO.getSellerName());

        return productsRepository.save(products);
    }
    public Products updateProduct(Long id, ProductsDTO productsDTO){
        return productsRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Products not found"));
    }

    public void deleteProduct(Long id){
        if (!productsRepository.existsById(id)){
            throw new RuntimeException("Products not found");
        }
        productsRepository.deleteById(id);
    }

}
