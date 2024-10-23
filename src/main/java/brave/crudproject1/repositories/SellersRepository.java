package brave.crudproject1.repositories;

import brave.crudproject1.entities.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellersRepository extends JpaRepository<Sellers,Long> {
}
