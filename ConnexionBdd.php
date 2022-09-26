<?php
$servername = "localhost";
$username = "root";
$password = "root";
$conn = NULL;

try {
    $conn = new PDO("mysql:host=$servername;dbname=takecar", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    //echo "Connected successfully";
    }
catch(PDOException $e)
    {
    echo "Connection failed: " . $e->getMessage();
    }

switch($_GET['action']){
	case 'inscription':
		inscription();
		break;
	case 'connexion':
		connexion();
		break;
}

function inscription(){
	$nom = $_POST["Nom"];
	$prenom = $_POST["Prenom"];
	$email = $_POST["Email"];
	$tel = $_POST["Telephone"];
	$id = $_POST["Login"];
	$mdp = $_POST["MotDepasse"];

	$conn = getBdd();
	$req = "INSERT INTO `Clients` ( `NomC`, `PrenomC`, `IdentifiantC`, `MdpC`, `EmailC`, `TelC`) VALUES ('$nom', '$prenom', '$id', '$mdp', '$email', '$tel')";
	$res = $conn->prepare($req);
	$res->execute();
	header('Location: index.php');
}

function connexion(){
	$id = $_POST["Login"];
	$mdp = $_POST["MotDepasse"];

	$conn = getBdd();
	$req = "SELECT `IdentifiantC`, `MdpC` FROM CLIENTS WHERE `IdentifiantC` = '$mdp' AND `MdpC` = '$mdp'";
	$res = $conn->prepare($req);
	$res->execute();
	$result = $res->fetch(PDO::FETCH_ASSOC);
	if(($result)){
		$_SESSION['login'] = $result['IdentifiantC'];
		header('Location: index.php');
	}
	else{
		echo 'paaaas bien';
	}
}

function getBdd(){
	$conn=null;
	$servername = "localhost";
	$username = "root";
	$password = "root";
 try {
    $conn = new PDO("mysql:host=$servername;dbname=takecar", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    //echo "Connected successfully";
    }
catch(PDOException $e)
    {
    echo "Connection failed: " . $e->getMessage();
    }
    return $conn;
 }
 ?>
