package brave.crudproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsDTO {
    private Long id;
    private String productName;
    private String categoryName;
    private String sellerName;
    private String categoryId;
}
