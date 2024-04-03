INSERT INTO topic (title) VALUES
('Тема 1'),
('Тема 2'),
('Тема 3');

INSERT INTO message (author, text, created_at, topic_id) VALUES
('User 1', 'Message 1 для Темы 1', NOW(), 1),
('User 2', 'Message 2 для Темы 1', NOW(), 1),
('User 3', 'Message 1 для Темы 2', NOW(), 2),
('User 4', 'Message 2 для Темы 2', NOW(), 2),
('User 5', 'Message 1 для Темы 3', NOW(), 3);