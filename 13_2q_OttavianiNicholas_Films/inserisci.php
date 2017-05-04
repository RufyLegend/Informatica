<!DOCTYPE html>
<html lang="en">

<!-- Intestazione -->
<head>
  <title>Inserisci</title>
  <link rel="stylesheet" href="stile.css" type="text/css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>

<form class="form-horizontal">
  <!--Titolo-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Titolo:</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="email" placeholder="Inserisci titolo">
    </div>
  </div>
  <!--Anno-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Anno Produzione:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" id="year" placeholder="Inserisci Anno">
    </div>
  </div>
  <!--Nazionalita-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Nazionalità:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" id="pwd" placeholder="Inserisci nazionalità">
    </div>
  </div>
  <!--Lingua-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Lingua:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" id="pwd" placeholder="Inserisci lingua">
    </div>
  </div>
  <!--Regista-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Regista:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" id="pwd" placeholder="Inserisci regista">
    </div>
  </div>
  <!-- Genere -->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Genere::</label>
    <div class="col-sm-8"> 
      <select class="form-control" id="genere" name="genere">
      <?php
            //includo la connessione in modo da non riscriverla più volte
            include '../connection/connection.php';

            $sql = "SELECT * from ruolo";
            $result = $connessione->query($sql);

            if ($result->num_rows > 0) {
                // output data of each row
                while($row = $result->fetch_assoc()) {
                  echo "<option value = " .$row["id_ruolo"]."> "  .$row["descrizione"]. "</option>";
                }
            } else {
            }
            $connessione->close();
            ?>
      </select>
    </div>
  </div>
  <!--Submit-->
</form>

</body>

</html>

