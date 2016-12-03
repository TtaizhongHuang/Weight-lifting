<?php
$servername = "mysql.confluence-rd.com";
$username = "vchapman";
$password = "a3E@2f1S$";

// Create connection
$conn = new mysqli($servername, $username, $password);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
echo "Connected successfully";
?> 