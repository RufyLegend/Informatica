<!DOCTYPE html>
<html lang="en">

<!-- Intestazione -->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/style.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
            include 'connection.php';

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
ho modificato

