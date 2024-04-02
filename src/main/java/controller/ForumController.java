package controller;

import com.example.forum.model.Message;
import com.example.forum.model.Topic;
import com.example.forum.service.MessageService;
import com.example.forum.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ForumController {
    private final TopicService topicService;
    private final MessageService messageService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }

    @PostMapping("/topics")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic createdTopic = topicService.createTopic(topic);
        return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
    }

    @PutMapping("/topics/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        return topicService.updateTopic(id, topicDetails);
    }

    @DeleteMapping("/topics/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/topics/{topicId}/messages")
    public List<Message> getMessagesByTopicId(@PathVariable Long topicId) {
        return messageService.getMessagesByTopicId(topicId);
    }

    @PostMapping("/topics/{topicId}/messages")
    public ResponseEntity<Message> createMessage(@PathVariable Long topicId, @RequestBody Message message) {
        message.setTopic(new Topic(topicId));
        Message createdMessage = messageService.createMessage(message);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    @PutMapping("/messages/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody Message messageDetails) {
        return messageService.updateMessage(id, messageDetails);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}

