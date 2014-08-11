<?php

require("common.php");

$subject = $adjectives[rand(0, (count($adjectives)-1))]." ".$subjects[rand(0, (count($subjects)-1))];

$string = ucfirst($subject);

echo '{ text: "'.$string.'" }';

?>