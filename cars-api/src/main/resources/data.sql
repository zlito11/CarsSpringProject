-- Inserting initial data into the User table
INSERT INTO user (name, email, password) VALUES ('User1', 'user1@example.com', 'password1hashed');
INSERT INTO user (name, email, password) VALUES ('User2', 'user2@example.com', 'password2hashed');
INSERT INTO user (name, email, password) VALUES ('User3', 'user3@example.com', 'password3hashed');

-- Inserting initial data into the Car table
INSERT INTO car (brand, type, desc, price, user_id) VALUES ('Tesla', 'Model S', 'Desc1', 10000, 1);
INSERT INTO car (brand, type, desc, price, user_id) VALUES ('Ford', 'Mustang', 'Desc2', 20000, 1);
INSERT INTO car (brand, type, desc, price, user_id) VALUES ('Toyota', 'Corolla', 'Desc3', 30000, 2);
INSERT INTO car (brand, type, desc, price, user_id) VALUES ('BMW', 'X5', 'Desc4', 40000, 2);
INSERT INTO car (brand, type, desc, price, user_id) VALUES ('Audi', 'A6', 'Desc5', 50000, 3);
INSERT INTO car (brand, type, desc, price, user_id) VALUES ('Mercedes', 'C-Class', 'Desc6', 60000, 3);