package az.emlak.emlakecommerce.repositories;

import az.emlak.emlakecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role ,Long> {
    Role findByName(String name);
}
