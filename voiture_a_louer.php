<!DOCTYPE html>
<html>
<head>
	<title>Louer une voiture</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="TakeCarStyleSheet2.css"/>
</head>
<body>
	  <div id="navbar">
        <span><a href="index.html"><img src="Logo-takecar.png" alt="logo" height="42" width="42" /></a></span>
        <a href="#Inscription">S'inscrire</a>
        <a href="#Connection">Connection</a>
        <a href="#contact">Contact</a>
		<a href="voiture_a_louer.php">Louer ma voiture</a>
    </div>
	
	<div class="cadreForm">
	<form method="POST" action="" id="myForm" enctype="multipart/form-data">
			<h1>Louer une voiture</h1>
			
			<div class="colonneGauche">
			<label for="marque" style="text-decoration: underline;">Marque</label> : 
			</br>
			<input type="text" name="marque" required>
			<br>
			<br>
			<label for="reference" style="text-decoration: underline;">Référence</label>:
			</br>
			<input type="text" name="Référence" required>
			<br>
			<br>	
			<label for="type" style="text-decoration: underline;">Type</label>:
			<br>
			<select name="type" size="1" required>
			<option>Berline
			<option>Citadine
			<option>Familiale
			<option>Utilitaire
			</select>
			<br>
			<br>
			<label for="annee" style="text-decoration: underline;">Année</label>:
			<br>
			<select name="year" size="1" required>
			<option>2018
			<option>2017
			<option>2016
			<option>2015
			<option>2014
			<option>2013
			<option>2012
			<option>2011
			<option>2010
			<option>2009
			<option>2008
			<option>2007
			<option>2006
			<option>2005
			<option>2004
			<option>2003
			<option>2002
			<option>2001
			<option>2000
			</select>
			<!--<input type="number" name="annee" required>-->
			</br>
			<br>
			
			
			
			<label for="kilometrage" style="text-decoration: underline;">Kilometrage</label> :
			</br>
			<input type="number" name="kilometrage" required>
			<br>
			<br>
			
			</div>
			
			<div class="colonneDroite">
			<label for="moteur" style="text-decoration: underline;">Moteur</label> :
			</br>
			<select name="moteur" size="1" required>
			<option>Diesel
			<option>Essence
			<option>Electrique
			</select>
			<br>
			<br>
			
			<label for="etat" style="text-decoration: underline;">Etat</label> :
			<br>
			<select name="etat" size="1" required>
			<option>Neuf
			<option>Bon etat
			<option>Mediocre
			</select>
			<br>
			<br>
			
			<label for="option" style="text-decoration: underline;">Option</label> : 
			</br>
			<input type="text" name="option" required>
			<br>
			<br>
			
			<label for="prix" style="text-decoration: underline;">Prix/h</label> : 
			</br>
			<input type="text" name="prix" required>
			<br>
			<br>
			
			
			
			
			<label for="file" style="text-decoration: underline;">Choisir l'image de la voiture</label> :
			<br>
			<br>
			<div><input type="file" onchange="handleFiles(files)" id="upload" multiple name="file"></div>
            <div><label for="upload"><span id="preview"></span></label></div>
			<script>
				function handleFiles(files) {
					var imageType = /^image\//;
				for (var i = 0; i < files.length; i++) {
				var file = files[i];
				if (!imageType.test(file.type)) {
					alert("veuillez sélectionner une image");
				}else{
					if(i == 0){
						preview.innerHTML = '';
					}
					var img = document.createElement("img");
					img.classList.add("obj");
					img.file = file;
					preview.appendChild(img); 
					var reader = new FileReader();
					reader.onload = ( function(aImg) { 
					return function(e) { 
					aImg.src = e.target.result; 
					}; 
				})(img);

				reader.readAsDataURL(file);
				}
 
				}
				}
			</script>

			
			<br>
			<br>
			<br>
			</div>
			<input id="myButton" type="button" value="Mettre à louer" name="kilometrage" required>
			
	</form>
	</div>
</body>
</html>