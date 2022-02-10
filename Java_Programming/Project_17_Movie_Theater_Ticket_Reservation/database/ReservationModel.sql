DROP DATABASE IF EXISTS RESERVATIONMODEL;
CREATE DATABASE RESERVATIONMODEL; 
USE RESERVATIONMODEL;

DROP TABLE IF EXISTS MOVIES;
CREATE TABLE MOVIES (
	Name varchar(25) not null,
    primary key (Name)
);
INSERT INTO MOVIES (Name) VALUES
("Squid Game"),
("Now You See Me"),
("Avengers: Endgame"),
("Spider-Man: No Way Home");


DROP TABLE IF EXISTS THEATER;
CREATE TABLE THEATER (
	Name varchar(50) not null,
    primary key (Name)
);
INSERT INTO THEATER (Name) VALUES
("Globe Cinema"),
("Landmark Cinemas Country Hills"),
("Cineplex Odeon Sunridge");

DROP TABLE IF EXISTS SHOWTIME;
CREATE TABLE SHOWTIME (
	ShowTimeID integer not null,
	MovieName varchar(50) not null,
    TheaterName varchar(50) not null,
    TheaterNumber varchar(4),
    ShowDate Date,
    ShowTime time,
    price integer,
    primary key (ShowTimeID),
    foreign key (MovieName) references MOVIES(Name),
    foreign key (TheaterName) references THEATER(Name)
);
INSERT INTO SHOWTIME (ShowTimeID, MovieName, TheaterName, TheaterNumber, ShowDate, ShowTime, price) VALUES
(1, "Squid Game", "Globe Cinema", 1, '2021-12-10', '10:00', 15),
(2, "Squid Game", "Globe Cinema", 1, '2021-12-11', '13:00', 15),
(3, "Squid Game", "Landmark Cinemas Country Hills", 1, '2021-12-12', '11:00', 15),
(4, "Squid Game", "Cineplex Odeon Sunridge", 1, '2021-12-13', '12:00', 15),
(5, "Now You See Me", "Landmark Cinemas Country Hills", 1, '2021-12-11', '10:00', 18),
(6, "Now You See Me", "Globe Cinema", 1, '2021-12-12', '09:00', 18),
(7, "Now You See Me", "Cineplex Odeon Sunridge", 1, '2021-12-13', '12:00', 18),
(8, "Now You See Me", "Globe Cinema", 1, '2021-12-10', '12:00', 18),
(9, "Avengers: Endgame", "Landmark Cinemas Country Hills", 1, '2021-12-11', '10:00', 14),
(10, "Avengers: Endgame", "Cineplex Odeon Sunridge", 1, '2021-12-11', '11:00', 14),
(11, "Avengers: Endgame", "Globe Cinema", 1, '2021-12-12', '12:00', 14),
(12, "Avengers: Endgame", "Globe Cinema", 1, '2021-12-13', '12:00', 14),
(13, "Spider-Man: No Way Home", "Globe Cinema", 1, '2021-12-11', '10:00', 25),
(14, "Spider-Man: No Way Home", "Cineplex Odeon Sunridge", 1, '2021-12-10', '11:00', 25),
(15, "Spider-Man: No Way Home", "Landmark Cinemas Country Hills", 1, '2021-12-12', '12:00', 25),
(16, "Spider-Man: No Way Home", "Cineplex Odeon Sunridge", 1, '2021-12-11', '12:00', 25);

DROP TABLE IF EXISTS RESERVATION;
CREATE TABLE RESERVATION (
    ReservationID INTEGER,
    ShowTimeID INTEGER,
    SeatRow INTEGER,
    SeatColumn INTEGER,
    userType VARCHAR(50) NOT NULL,
    FOREIGN KEY (ShowTimeID)
	REFERENCES SHOWTIME (ShowTimeID)
);

INSERT INTO RESERVATION (ReservationID, ShowTimeID, SeatRow, SeatColumn, userType) VALUES
(1001, 1, 1, 2, "Registered"),
(1002, 5, 1, 1, "User"),
(1003, 3, 2, 1, "User"),
(1007, 13, 1, 2, "User"),
(1008, 11, 1, 2, "User"),
(1009, 4, 2, 2, "User"),
(1010, 9, 1, 1, "Registered"),
(1011, 4, 2, 1, "User");















