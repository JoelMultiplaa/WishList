-- Create database
CREATE DATABASE my_wishlist_database;
USE my_wishlist_database;

-- Create tables
CREATE TABLE IF NOT EXISTS Users(
USER_ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
USERNAME VARCHAR(20) NOT NULL UNIQUE );

CREATE TABLE IF NOT EXISTS Wishes(
WISHES_ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
WISH VARCHAR(15) NOT NULL UNIQUE );

CREATE TABLE IF NOT EXISTS WishList(
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
NAME VARCHAR(20) NOT NULL UNIQUE,
DESCRIPTION VARCHAR(100),
USER_ID INT,
WISHES_ID INT,
FOREIGN KEY (USER_ID) REFERENCES Users(USER_ID),
FOREIGN KEY (WISHES_ID) REFERENCES Wishes(WISHES_ID) );



-- Indsæt data i Users
INSERT INTO Users (USERNAME) VALUES ('Berzan'), ('Ali');

-- Indsæt data i Wishes
INSERT INTO Wishes (WISH) VALUES ('iPhone'), ('PlayStation');

-- Indsæt data i WishList
INSERT INTO WishList (NAME, DESCRIPTION, USER_ID, WISHES_ID) VALUES
('Holiday Gifts', 'Gifts for the holiday season', (SELECT USER_ID FROM Users WHERE USERNAME = 'Berzan'), (SELECT WISHES_ID FROM Wishes WHERE WISH = 'iPhone')),
('Birthday Gifts', 'Gifts for upcoming birthdays', (SELECT USER_ID FROM Users WHERE USERNAME = 'Ali'), (SELECT WISHES_ID FROM Wishes WHERE WISH = 'PlayStation')),
('Eid Gifts', 'Gifts for upcoming Eid days', (SELECT USER_ID FROM Users WHERE USERNAME = 'Joel'), (SELECT WISHES_ID FROM Wishes WHERE WISH = 'Real madrid shirt'));


SELECT
    WishList.NAME AS List_Name,
    WishList.DESCRIPTION AS List_Description,
    Users.USERNAME AS User_Name,
    Wishes.WISH AS Wish_Item
FROM
    WishList
    JOIN Users ON WishList.USER_ID = Users.USER_ID
    JOIN Wishes ON WishList.WISHES_ID = Wishes.WISHES_ID;