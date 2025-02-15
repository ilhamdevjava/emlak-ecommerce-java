package az.emlak.emlakecommerce.services;

import az.emlak.emlakecommerce.dtos.contact.ContactUpdateDto;
import az.emlak.emlakecommerce.model.Contact;
import az.emlak.emlakecommerce.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact getContactInfo() {
        return contactRepository.findFirstByOrderByIdAsc();
    }

    public void updateContactInfo(Contact contact) {
        contactRepository.save(contact);
    }
    // ContactUpdateDto kullanarak güncelleme yapan metod
    public void updateContactInfo(ContactUpdateDto contactUpdateDto) {
        Contact contact = getContactInfo(); // Mevcut bilgileri al

        // DTO'dan gelen verileri modelle eşleştir
        contact.setEmail(contactUpdateDto.getEmail());
        contact.setPhone(contactUpdateDto.getPhone());
        contact.setAddress(contactUpdateDto.getAddress());

        // Güncellenmiş verileri kaydet
        contactRepository.save(contact);
    }
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found!"));
    }

    public void updateContact(Long id, ContactUpdateDto contactUpdateDto) {
        Contact contact = getContactById(id); // Mevcut kaydı alın
        contact.setEmail(contactUpdateDto.getEmail());
        contact.setPhone(contactUpdateDto.getPhone());
        contact.setAddress(contactUpdateDto.getAddress());
        contactRepository.save(contact); // Güncellenmiş kaydı kaydedin
    }
}
