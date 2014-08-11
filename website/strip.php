<?php

require("common.php");

if ($seed) {
	srand($seed);
}

if (!$orientation) {
	$orientation = 'l';
}

$subject = $adjectives[rand(0, (count($adjectives)-1))]." ".$subjects[rand(0, (count($subjects)-1))];


if (is_dir($dirPath)) {
	if ($dh = opendir($dirPath)) {
		//error_reporting(E_ALL ^ E_WARNING);

if ($images) {

	$paramimages = explode ('|', base64_decode($images));

	for($i=0; $i<count($paramimages); $i++) {
		$imgSrc[$i][0] = $dirPath.$paramimages[$i].".".$ext;
	}

} else {

		while (($filename = readdir($dh)) !== false) {
			if(getimagesize($dirPath.$filename)) {
				if (strpos($filename, "a.")) {
					$imgSrc[0][count($imgSrc[0])] = $dirPath.$filename;
				} else if (strpos($filename, "b.")) {
					$imgSrc[1][count($imgSrc[1])] = $dirPath.$filename;
				} else if (strpos($filename, "c.")) {
					$imgSrc[2][count($imgSrc[2])] = $dirPath.$filename;
				}
			}
		}

}

		$outputImage = imagecreatetruecolor($width, $height);
		$white = imagecolorallocate($outputImage, 255, 255, 255);
		$grey = imagecolorallocate($outputImage, 128, 128, 128);
		$string = ucfirst($subject);

		//select three images, image is 167x149
		if ($orientation == 'l' {
			imagefilledrectangle($outputImage, 0, 0, $width, $height, $white);

			for($i=0; $i<count($imgSrc); $i++) {

				$temp = imagecreatefrompng($imgSrc[$i][rand(0, (count($imgSrc[$i])-1))]);
				imagecopymerge($outputImage, $temp, $i*($width/3), 0, 0, 0, $width/3, $height-20, 100);

			}
		
			imagettftextalign($outputImage, 14, 0, $width/2, $height-4, $grey, "./WTTWmessy.ttf", $string, 'C');
		} else {
			imagefilledrectangle($outputImage, 0, 0, $widthPortrait, $heightPortrait, $white);

			for($i=0; $i<count($imgSrc); $i++) {

				$temp = imagecreatefrompng($imgSrc[$i][rand(0, (count($imgSrc[$i])-1))]);
				imagecopymerge($outputImage, $temp, 0, $i*149, 0, 0, 167, 149, 100);

			}
		
			imagettftextalign($outputImage, 14, 0, $widthPortrait/2, $heightPortrait-4, $grey, "./WTTWmessy.ttf", $string, 'C');
		}

		



	}
}

header('Content-type: image/png');
imageinterlace($outputImage, true);
imagepng($outputImage);

imagedestroy($outputImage);


function imagettftextalign($image, $size, $angle, $x, $y, $color, $font, $text, $alignment='L') 
{ 

   //check width of the text 
   $bbox = imagettfbbox ($size, $angle, $font, $text); 
   $textWidth = $bbox[2] - $bbox[0]; 
   switch ($alignment) { 
       case "R": 
           $x -= $textWidth; 
           break; 
       case "C": 
           $x -= $textWidth / 2; 
           break; 
   } 

   //write text 
   imagettftext ($image, $size, $angle, $x, $y, $color, $font, $text); 

} 

//error_reporting(E_ALL);
?>