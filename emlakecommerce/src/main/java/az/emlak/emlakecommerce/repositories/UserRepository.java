package az.emlak.emlakecommerce.repositories;

import az.emlak.emlakecommerce.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <UserEntity,Long> {
    UserEntity findByEmail(String email);
}
