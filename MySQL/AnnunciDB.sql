DROP DATABASE IF EXISTS AnnunciDB;
CREATE DATABASE AnnunciDB;
USE AnnunciDB;

CREATE TABLE Utente(
	utenteID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
   	username VARCHAR(250) UNIQUE NOT NULL,
	pass VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) NOT NULL
);

CREATE TABLE Annuncio(
	annuncioID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	codice VARCHAR(250) NOT NULL,
    titolo VARCHAR(250) NOT NULL,
    testo VARCHAR(250) NOT NULL,
    publicazione DATETIME DEFAULT CURRENT_TIMESTAMP,
    utenteRIF INTEGER NOT NULL,
	FOREIGN KEY (utenteRIF) REFERENCES Utente(utenteID)
);

INSERT INTO utente(username, pass, email, telefono) VALUES
('Matteo','1234','matben32@gmail.com','3890036943'),
('Valerione','1234','valerio@gmail.com','3890036943');

INSERT INTO annuncio(codice, titolo, testo, utenteRIF) VALUES
('1234','ann 1',"Descrizione 1",1),
('Stanza2','STA2',"Descrizione 2",2);

SELECT * FROM Annuncio 
	JOIN Utente ON Utente.utenteID=Annuncio.utenteRIF;
    
    
SELECT * FROM Utente 