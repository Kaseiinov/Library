INSERT INTO category (category)
VALUES ('Fiction'),
       ('Science'),
       ('Technology'),
       ('History'),
       ('Biography');

INSERT INTO authorities (authority)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN'),
       ('ROLE_MODERATOR');

INSERT INTO roles (role_name)
VALUES ('USER'),
       ('ADMIN'),
       ('LIBRARIAN');

INSERT INTO roles_authorities (role_id, authority_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 3);

INSERT INTO users (first_name, last_name, passport, password, ticket, enabled)
VALUES ('John', 'Doe', 'AB123', '$2a$10$6nut.IFSaV9Ez2v3zKutyeHpYVUTIpex8fWPAi8CfrwTC0WHRGD/G', 'TICKET001', true),
       ('Jane', 'Smith', 'CD899', '$2a$10$6nut.IFSaV9Ez2v3zKutyeHpYVUTIpex8fWPAi8CfrwTC0WHRGD/G', 'TICKET002', true),
       ('Admin', 'User', 'EF121', '$2a$10$6nut.IFSaV9Ez2v3zKutyeHpYVUTIpex8fWPAi8CfrwTC0WHRGD/G', 'TICKET003', true),
       ('Bob', 'Johnson', 'GH151', '$2a$10$6nut.IFSaV9Ez2v3zKutyeHpYVUTIpex8fWPAi8CfrwTC0WHRGD/G', 'TICKET004', true);
-- password -> pas

INSERT INTO usr_roles (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 3);

INSERT INTO book (name, author, available, avatar, return_date, category_id)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', true, 'images.jpeg', NULL, 1),
       ('A Brief History of Time', 'Stephen Hawking', true, 'images.jpeg', NULL, 2),
       ('Clean Code', 'Robert C. Martin', false, 'images.jpeg', '2025-10-15', 3),
       ('Sapiens', 'Yuval Noah Harari', true, 'images.jpeg', NULL, 4),
       ('Steve Jobs', 'Walter Isaacson', true, 'images.jpeg', NULL, 5),
       ('Kaseiinov Islam', 'Book 1', true, 'images.jpeg', NULL, 1),
       ('Kaseiinov Islam', 'Book 2', true, 'images.jpeg', NULL, 2),
       ('Kaseiinov Islam', 'Book 3', true, 'images.jpeg', NULL, 3);

INSERT INTO usr_books (user_id, book_id)
VALUES (1, 1),
       (1, 3),
       (2, 2),
       (3, 4),
       (4, 5);

INSERT INTO history (id)
VALUES (1),
       (2),
       (3);