package brave.crudproject1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String categoryName;
    private String SellerName;
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
}
