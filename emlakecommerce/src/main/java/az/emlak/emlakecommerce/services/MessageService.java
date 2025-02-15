package az.emlak.emlakecommerce.services;

import az.emlak.emlakecommerce.model.Message;
import az.emlak.emlakecommerce.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(Message message) {
        if (message.getIsRead() == null) {
            message.setIsRead(false); // Varsayılan olarak false atandı
        }
        messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }


    public List<Message> getUnreadMessages() {
        return messageRepository.findUnreadMessages();
    }

    public long getUnreadMessageCount() {
        return messageRepository.countByIsReadFalse();
    }

    public void markAllMessagesAsRead() {
        List<Message> unreadMessages = messageRepository.findByIsReadFalse();
        unreadMessages.forEach(message -> message.setIsRead(true));
        messageRepository.saveAll(unreadMessages);
    }
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }
    public List<Message> getRecentMessages(int limit) {
        return messageRepository.findTopNByOrderBySentAtDesc(limit);
    }
}
