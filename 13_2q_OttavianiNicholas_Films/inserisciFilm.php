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

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.html"><strong>FILMS</strong></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="inserisciFilm.php">Inserisci Film</a></li>
      <li><a href="inserisciGenere.php">Inserisci Genere</a></li>
      <li><a href="visualizzaGenere.php">Generi</a></li><li>
      <li><a href="visualizzaFilm.php">Film</a></li>
    </ul>
  </div>
</nav>

<body>
<!-- Form Inserimento -->
<div class="container">
<form class="form-horizontal" role="inserisciFilm">
  <!--Titolo-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Titolo:</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" name="titolo" id="titolo" placeholder="Inserisci titolo">
    </div>
  </div>
  <!--Anno-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Anno Produzione:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="anno" id="anno" placeholder="Inserisci anno">
    </div>
  </div>
  <!--Nazionalita-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Nazionalità:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="nazionalita" "id="nazionalita" placeholder="Inserisci nazionalità">
    </div>
  </div>
  <!--Lingua-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Lingua:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="lingua" id="lingua" placeholder="Inserisci lingua">
    </div>
  </div>
  <!--Regista-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Regista:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="regista" id="regista" placeholder="Inserisci regista">
    </div>
  </div>
  <!-- Genere -->
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Genere:</label>
    <div class="col-sm-8"> 
      <select class="form-control" id="genere" name="genere">
      <?php
            //Connessione al DB
            include 'connection.php';

            $sql = "SELECT * from generi";
            $result = $connessione->query($sql);

            if ($result->num_rows > 0) {
                //Per ogni riga 
                while($row = $result->fetch_assoc()) {
                  echo "<option value = " .$row["id"] .">". $row["genere"] ."</option>";
                }
            } else {
            }
            $connessione->close();
            ?>
      </select>
    </div>
  </div>
  <!--Submit-->
  <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <button type="submit" id="addFilm" class="btn btn-primary " value="Send">Aggiungi</button>
      </div>
  </div>
  
 <!--response message - positive-->
 <div class="alert alert-success a" id="alert-success" style="visibility:hidden;">
    <strong>OK! </strong> Film Aggiunto
 </div>
 <!--response message - negative-->
 <div class="alert alert-danger " id="alert-error" style="visibility:hidden;">   
    <strong>Opss!</strong> Ci deve essere qualche problema
  </div>
  
</form>
</div>

<script>
  $(function() {
    $("form").submit(function() {
        $.ajax({
            type: 'POST',
            url: 'filmPostScript.php',
            data: $(this).serialize(),
            success: function(data) {
                console.log(data);
              if (data == "ok"){
                 $('#alert-success').css({
                  visibility:'visible'
                });
              }else{
                 $('#alert-error').css({
                  visibility:'visible'
                });
              }  
            }
            
        });
      
        return false;
    }); 
})


</script>


</body>

</html>

