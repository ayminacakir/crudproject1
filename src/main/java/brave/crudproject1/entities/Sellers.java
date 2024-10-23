package brave.crudproject1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sellers")
@Getter
@Setter
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seller_name;
    private String seller_adress;
    private String seller_phone;
}
