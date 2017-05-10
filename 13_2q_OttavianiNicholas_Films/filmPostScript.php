<?php
include 'connection.php';

$titolo = $_POST['titolo'];
$anno = $_POST['anno'];
$nazionalita = $_POST['nazionalita'];
$lingua = $_POST['lingua'];
$regista = $_POST['regista'];
$genere = $_POST['genere'];

$sql = "INSERT INTO films (titolo, annoProduzione, nazionalita, lingua, regista, idGenere)
		VALUES ('$titolo', '$anno', '$nazionalita', '$lingua', '$regista', '$genere')";

if ($connessione->query($sql) === TRUE) {
	echo "ok";
} else {
	echo "Error: " . $sql . "<br>" . $connessione->error;
}

$connessione->close();

?> 