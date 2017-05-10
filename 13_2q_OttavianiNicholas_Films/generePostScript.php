<?php
include 'connection.php';

$genere =$_POST["genere"];

$sql = "INSERT INTO generi (genere) VALUES ('$genere');";

if ($connessione->query($sql) === TRUE) {
	echo "ok";
} else {
	echo "Error: " . $sql . "<br>" . $connessione->error;
}

?>