package com.example.forum.service;

import com.example.forum.model.Message;
import com.example.forum.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> getMessagesByTopicId(Long topicId) {
        return messageRepository.findByTopicId(topicId);
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMessage(Long id, Message messageDetails) {
        Message message = getMessageById(id);
        message.setAuthor(messageDetails.getAuthor());
        message.setText(messageDetails.getText());
        message.setCreatedAt(messageDetails.getCreatedAt());
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    private Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found with id " + id));
    }
}
