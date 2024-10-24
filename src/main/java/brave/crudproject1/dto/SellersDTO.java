package brave.crudproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellersDTO {
    private String sellerName;
    private String sellerAdress;
    private String sellerPhone;
    private String productName;
}

