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
      <li><a href="inserisciFilm.php">Inserisci Film</a></li>
      <li class="active"><a href="inserisciGenere.php">Inserisci Genere</a></li>
      <li><a href="visualizzaGenere.php">Generi</a></li><li>
      <li><a href="visualizzaFilm.php">Film</a></li>
    </ul>
  </div>
</nav>

<body>

<!-- Form Inserimento -->
<div class="container">
<form class="form-horizontal" role="inserisciFilm">
  <!--Genere-->
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Nome Genere:</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" name="genere" id="titolo" placeholder="Inserisci nome">
    </div>
  </div>
  <!-- Submit -->
  <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <button type="submit" id="addGenere" class="btn btn-primary " value="Send">Inserisci</button>
      </div>
  </div>
  <!--response message - positive-->
 <div class="alert alert-success a" id="alert-success" style="visibility:hidden;">
    <strong>Inserimento Eseguito con successo! </strong>
 </div>
 <!--response message - negative-->
 <div class="alert alert-danger " id="alert-error" style="visibility:hidden;">   
    <strong>Errore di inserimento</strong>
 </div>
</form>
</div>
<!-- Script Richiesta AJAX per inserire il genere -->
<script>
  $(function() {
    $("form").submit(function() {
        $.ajax({
            type:'POST',
            url: 'generePostScript.php',
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
