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
        Products product = productsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
    int stockQuantity = productsRepository.findStockQuantityById(id); //Stok miktarını kontrol eden bir koşul ekledim. metot çağrılırken id değerini giriyorum.
    if (stockQuantity <= 0){
        throw new RuntimeException("Product is out of stock");
    }
    return product;
    }
    public Products createProducts(ProductsDTO productsDTO){
       if(!productsRepository.existsByCategoryName(productsDTO.getCategoryName())){ //var olan bir kategoriye ürün yaratmak istedim.Kategori yoksa exception fırlattım.
           throw new RuntimeException("Category"+productsDTO.getProductName()+"doesn't exit.");
       }

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
