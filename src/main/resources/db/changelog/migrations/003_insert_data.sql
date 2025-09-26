-- Insert into category table
INSERT INTO category (category)
VALUES ('Fiction'),
       ('Science'),
       ('Technology'),
       ('History'),
       ('Biography');

-- Insert into authorities table
INSERT INTO authorities (authority)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN'),
       ('ROLE_MODERATOR');

-- Insert into roles table
INSERT INTO roles (role_name)
VALUES ('USER'),
       ('ADMIN'),
       ('LIBRARIAN');

-- Insert into roles_authorities table (linking roles to authorities)
INSERT INTO roles_authorities (role_id, authority_id)
VALUES (1, 1), -- USER has ROLE_USER
       (2, 1), -- ADMIN has ROLE_USER
       (2, 2), -- ADMIN has ROLE_ADMIN
       (3, 1), -- LIBRARIAN has ROLE_USER
       (3, 3);
-- LIBRARIAN has ROLE_MODERATOR

-- Insert into users table
INSERT INTO users (first_name, last_name, passport, password, ticket, enabled)
VALUES ('John', 'Doe', 'AB1234567', 'encoded_password_1', 'TICKET001', true),
       ('Jane', 'Smith', 'CD8910111', 'encoded_password_2', 'TICKET002', true),
       ('Admin', 'User', 'EF1213141', 'encoded_password_3', 'TICKET003', true),
       ('Bob', 'Johnson', 'GH1516171', 'encoded_password_4', 'TICKET004', true);

-- Insert into usr_roles table (assign roles to users)
INSERT INTO usr_roles (user_id, role_id)
VALUES (1, 1), -- John Doe has USER role
       (2, 1), -- Jane Smith has USER role
       (3, 2), -- Admin User has ADMIN role
       (4, 3);
-- Bob Johnson has LIBRARIAN role

-- Insert into book table
INSERT INTO book (name, author, available, avatar, return_date, category_id)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', true, 'gatsby.jpg', NULL, 1),
       ('A Brief History of Time', 'Stephen Hawking', true, 'time.jpg', NULL, 2),
       ('Clean Code', 'Robert C. Martin', false, 'cleancode.jpg', '2025-10-15', 3),
       ('Sapiens', 'Yuval Noah Harari', true, 'sapiens.jpg', NULL, 4),
       ('Steve Jobs', 'Walter Isaacson', true, 'jobs.jpg', NULL, 5);

-- Insert into usr_books table (which books users have)
INSERT INTO usr_books (user_id, book_id)
VALUES (1, 1), -- John Doe has The Great Gatsby
       (1, 3), -- John Doe has Clean Code (currently borrowed)
       (2, 2), -- Jane Smith has A Brief History of Time
       (3, 4), -- Admin User has Sapiens
       (4, 5);
-- Bob Johnson has Steve Jobs

-- Insert into history table (if you need sample history records)
INSERT INTO history (id)
VALUES (1),
       (2),
       (3);