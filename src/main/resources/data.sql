DROP DATABASE IF EXISTS wishlist;
CREATE DATABASE wishlist;
USE wishlist;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS wish;
DROP TABLE IF EXISTS wishlist;

CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      firstname VARCHAR(50) NOT NULL,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL
);

CREATE TABLE wishlist (
                          id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          user_id int,
                          name VARCHAR(40) NOT NULL,
                          description VARCHAR(255),
                          FOREIGN KEY(user_id) REFERENCES user(id)
);

CREATE TABLE wish (
                      id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      wishlist_id int,
                      name VARCHAR(40) NOT NULL,
                      price int(50) NOT NULL,
                      description VARCHAR(50),
                      FOREIGN KEY (wishlist_id) REFERENCES wishlist(id)
);




INSERT INTO user (firstname, username, password)
VALUES
    ('Ali', 'Ali17','A123'),
    ('Berzan', 'HalaBerzan', 'Servuran'),
    ('Joel', 'JoJo25', 'HowToMakeMoney');

INSERT INTO wishlist (user_id, name, description)
VALUES
    (1,'julegaver', 'gaver jeg ønsker til gaven'),
    (2,'eid gaver', 'gaver til eid');
/* TEST DATA FOR WISHES */
INSERT INTO wish (wishlist_id, name, description, price)
VALUES
    (1, 'Beaver',  'I want a cute beaver', 200),
    (1, 'Goose', 'I want goose baby', 300),
    (2, 'Justin Bieber','I want Justin biber, cause he´s cute!', 300),
    (2, 'Rubber Duck', 'I need a coding buddy', 300);
