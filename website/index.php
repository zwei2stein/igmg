<?php 

require("common.php");

if (!$seed) {
$seed=rand();
} else {
$resume=1;
}

srand($seed);

$subject = $adjectives[rand(0, (count($adjectives)-1))]." ".$subjects[rand(0, (count($subjects)-1))];
$alt = ucfirst($subject);
$quote = $nietscheQuotes[rand(0, (count($nietscheQuotes)-1))];

$imgSrc = getImagePool();

if (!$images) {
	$images = preg_replace("/=/", "", base64_encode($imgSrc[0][rand(0, (count($imgSrc[0])-1))].'|'.$imgSrc[1][rand(0, (count($imgSrc[1])-1))].'|'.$imgSrc[2][rand(0, (count($imgSrc[2])-1))]));
}

$combinations = count($adjectives) * count($subjects) * count($imgSrc[0]) * count($imgSrc[1]) * count($imgSrc[2]);
		
?>

<html>
<head>
	<meta http-equiv="description" content="Window into sad, empty life of Jon who battles with his insanity." />
	<meta http-equiv="keywords" content="grafield strip creator generator randomizer <?php echo $subject; ?>" />
	<link rel="stylesheet" href="./style.css" type="text/css" />
	<link rel="shortcut icon" href="./icon.png" type="image/png" />
	<title>Infinite Garfield Minus Garfield: <?php echo ucfirst($subject); ?></title>
</head>
<body>
	<h1>In<em>finite</em> Garfield Minus Garfield</h1>

<div id="topOfPicture">

<?php if ($resume) { ?>
<p>Share <a href="strip.<?php echo $seed.".".$images; ?>.html">this</a> one ...</p>
<?php } else { ?>
<a href="strip.<?php echo $seed.".".$images; ?>.html" class="permalink">permalink</a>
<p>Press <strong>F5</strong>...</p>

</div>

<?php } ?>

	<a href="strip.<?php echo $seed.".".$images; ?>.html" id="permaLink"><img src="strip.<?php echo $seed.".".$images; ?>.png" alt="<?php echo $alt.": ".$quote; ?>" title="<?php echo $alt.": ".$quote; ?>" /></a>

<?php if ($resume) { ?>
	<p>...or <a href="./">resume</a> randomizing.</p>
<?php } else { ?>
	<p>...or click <strong>refresh</strong>.</p>
<?php } ?>

<a href="https://play.google.com/store/apps/details?id=cz.zweistein.android.infinitegarfieldminusgarfield">
  <img alt="Android app on Google Play"
       src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

	<div>
		<?php echo number_format($combinations, 0, '', ' '); ?> combinations courtesy of <a href="http://garfieldminusgarfield.net">G-G</a> vs. <a href="http://en.wikipedia.org/wiki/Friedrich_Nietzsche">Nietzsche</a> vs. <a href="http://www.garfield.com">Garfield</a>.
	</div>
	<div id="author">
		2010, <a href="http://devdiary.zweistein.cz">Petr</a> <a href="maito:zwei2stein@gmail.com">Prokop</a>
	</div>
</body>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-16153646-1");
pageTracker._trackPageview();
} catch(err) {}</script>

</html>