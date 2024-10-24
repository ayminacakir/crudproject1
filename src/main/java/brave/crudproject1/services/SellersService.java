package brave.crudproject1.services;

import brave.crudproject1.dto.SellersDTO;
import brave.crudproject1.entities.Sellers;
import brave.crudproject1.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellersService {
    @Autowired
    private SellersRepository sellersRepository;

    public List<Sellers>getAllSellers(){
        return sellersRepository.findAll();
    }
    public Sellers getSellerById(Long id){
        return sellersRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Seller not found"));
    }
    public Sellers createSeller(SellersDTO sellersDTO){
        Sellers sellers = new Sellers();
        sellers.setSellerName(sellersDTO.getSellerName());
        sellers.setSellerAdress(sellersDTO.getSellerAdress());
        sellers.setSellerPhone(sellersDTO.getSellerPhone());

        return sellersRepository.save(sellers);
    }
    public Sellers updateSeller(Long id, SellersDTO sellersDTO){
        return sellersRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Seller not found"));
    }
    public void deleteSeller(Long id) {
        sellersRepository.deleteById(id);
    }

}
