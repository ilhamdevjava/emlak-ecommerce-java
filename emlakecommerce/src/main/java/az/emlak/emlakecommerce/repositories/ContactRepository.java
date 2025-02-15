package az.emlak.emlakecommerce.repositories;

import az.emlak.emlakecommerce.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findFirstByOrderByIdAsc();


}
