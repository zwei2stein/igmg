<?php 

require("common.php");

$imgSrc = getImagePool();

$images = getUrlString($imgSrc);

echo '{ a: [';
for($i=0; $i<count($imgSrc[0]); $i++) {
	if ($i != 0) {
		echo ', ';
	}
	echo '"'.$imgSrc[0][$i].'"';
}
echo '], b: [';
for($i=0; $i<count($imgSrc[1]); $i++) {
	if ($i != 0) {
		echo ', ';
	}
	echo '"'.$imgSrc[1][$i].'"';
}
echo '], c: [';
for($i=0; $i<count($imgSrc[2]); $i++) {
	if ($i != 0) {
		echo ', ';
	}
	echo '"'.$imgSrc[2][$i].'"';
}
echo '] }';

?>