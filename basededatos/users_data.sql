use digitalRentcarUsers;

-- ROLES
INSERT INTO roles (name) VALUES ("admin");
INSERT INTO roles (name) VALUES ("employee");
INSERT INTO roles (name) VALUES ("user");

-- USERS
INSERT INTO users (name, last_name, email, password, role_id) VALUES ("Sergio", "Garcia", "sergiogarcia@gmail.com", "$2a$10$QlLVjuZo78y089053BCH7eH2.X6QLaeWJlqESgvspUOOvDz0jg44e", 1);
INSERT INTO users (name, last_name, email, password, role_id) VALUES ("Lina", "Huertas", "linahuertas@gmail.com", "$2a$10$QimXJjW0WrWEuMq79l/1AuOweIRM6E3khvtBAbgsTaMiwomTRQROy", 1);
INSERT INTO users (name, last_name, email, password, role_id) VALUES ("Juan", "Rojas", "juanrojas@email.com", "$2a$10$747KQfpn43IjjLQ8cwgh2.8fzbcxfBLmIg3XgiZc8ema3y64NBX.a", 1);