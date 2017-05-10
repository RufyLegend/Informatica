<?php
$servername = "localhost:3306";
$username = "root";
$password = "";
$dbname = "film";

// Create connection
$connessione = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($connessione->connect_error) {
	die("Connessione fallita: " . $connessione->connect_error);
	echo "fail!";
}

?>

