<!DOCTYPE html>
<?php 
 include ('ConnexionBdd.php');
?>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="TakeCarStyleSheet.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="fichierText.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Resultat</title>
</head>
<body>
	<style> 
	.corp{
		margin-top: 60px!important;
		width: 70%;
		text-align: center;
		margin: auto;
		background-color: #8C7A86;
		color: white;
	}
	.col1{
		border-right: 1px solid lightgray;
		border-collapse: collapse;
	}
	.col1, .col2{
		border-bottom: 1px solid lightgray;
		padding: ;
	}
	.btn_res{
		width: 100%;
		margin-bottom:20px;
		background-color: white;
		color: #8C7A86;
	}


</style>

<div id="navbar">
        <span><a href="index.php"><img src="Logo-takecar.png" alt="logo" height="42" width="42" /></a></span>
        <a href="#Inscription">S'inscrire</a>
        <a href="#Connection">Connection</a>
        <a href="#contact">Contact</a>
</div>
<div class="corp container">
<?php

	$req = "SELECT * FROM VOITURES";
	$res = $conn->prepare($req);
	$res->execute();
	$result = $res->fetchAll(PDO::FETCH_ASSOC);

	for($i = 0; $i < count($result); $i++){
		echo 	'<div class="col1 col-sm-6">
					<img src="http://sf2.viepratique.fr/wp-content/uploads/sites/9/2017/01/fiat-tipo-750x410.jpg" height="210px" width="408px">
					<span>
						<p>à 20 m</p>
					</span>
					<span>
						' . $result[$i]['AnneeVeh'] . ' - ' . $result[$i]['MarqueVeh'] . ' ' . $result[$i]['ReferenceVeh'] . ' - ' . $result[$i]['MoteurVeh'] . '
					</span>
					<div>
						<button class="btn btn-primary btn_res">Réserver</button>
					</div>
				</div>';
	}
?>
</div>

</body>
</html>