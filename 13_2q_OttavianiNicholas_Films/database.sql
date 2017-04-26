

CREATE TABLE film(
	id INT PRIMARY KEY,
	titolo VARCHAR(100) NOT NULL,
	annoProduzione DATE NOT NULL,
	nazionalita VARCHAR(50) NOT NULL,
	lingua VARCHAR(20) NOT NULL,
	codiceRegista INT NOT NULL
);

CREATE TABLE genereFilm(
	film INT NOT NULL,
	genere VARCHAR(100),
	PRIMARY KEY (film, genere),
	FOREIGN KEY film REFERENCES film(id)
)