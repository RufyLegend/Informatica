<!DOCTYPE html>
<html lang="en">

<!-- Intestazione -->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<!-- Nav Bar -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.html"><strong>FILMS</strong></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="inserisciFilm.php">Inserisci Film</a></li>
      <li><a href="inserisciGenere.php">Inserisci Genere</a></li>
      <li class="active"><a href="visualizzaGenere.php">Generi</a></li><li>
      <li><a href="visualizzaFilm.php">Film</a></li>
    </ul>
  </div>
</nav>

<body>
<div class="container">
  <h2>Lista dei generi</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Generi:</th>
      </tr>
    </thead>
    <tbody>
    	<?php
            include 'connection.php';
            $sql = "SELECT genere FROM generi;";
            $result = $connessione->query($sql);

            if ($result->num_rows > 0) {
                // output data of each row
                while($row = $result->fetch_assoc()) {
           
                    echo "<tr>" ;//open tr
                    echo "<td>" .$row["genere"]. "</td>";
                    echo "</tr>";//close tr
                }
            } else {
                echo "0 results";
            }
            $connessione->close();
            ?>
    </tbody>
  </table>
</div>
</body>
</html>

