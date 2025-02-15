package az.emlak.emlakecommerce.repositories;

import az.emlak.emlakecommerce.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByIsReadFalse(); // Güncel alan adıyla

    List<Message> findByIsReadFalseOrderBySentAtDesc();

    // Belirli bir mesajı ID ile getir
    Message findById(long id);

    @Query("SELECT m FROM Message m WHERE m.isRead = false ORDER BY m.sentAt DESC")
    List<Message> findUnreadMessages();

    long countByIsReadFalse();

    @Query("SELECT m FROM Message m ORDER BY m.sentAt DESC")
    List<Message> findTopNByOrderBySentAtDesc(@Param("limit") int limit);

}
