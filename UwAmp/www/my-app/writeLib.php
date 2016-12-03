<?php

//I echo this to see if I get anythnig but I do not
$msg = htmlspecialchars($_POST['books']);
//$books = json_decode(file_get_contents('php://input'),true);
echo("here ");
echo($msg);
echo("Hello");
if(filesize("books.txt") != 0){
	$myfile = fopen("books.txt", "r") or die("Unable to open file!");
	$posts = fread($myfile,filesize("books.txt"));
	$classPosts = json_decode($posts);
	fclose($myfile);
}


array_push($classNew, $book);
$classNew = json_encode($classNew);
file_put_contents("books.txt", $classNew);
//echo("Sucess");
?>