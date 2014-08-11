<?php

$subjects = array("loneliness", "solitude", "emptiness", "depression", "despair", "celibacy", "resentment", "hopelessness", "insanity", "desperation", "misery", "abandonment", "frustration", "dysfunction", "abnormality", "grief", "anguish", "rejection", "humiliation", "isolation", "regret", "shame", "disownment", "deviance", "weakness", "deficiency", "impotence", "instability", "powerlessness", "failure", "breakdown", "disappointment", "bitterness", "contempt");
//$subjects = array("garfield");

$adjectives = array("empty", "crushing", "delicate", "void", "abandoned", "bare", "forsaken", "hollow", "friendless", "solitary", "isolated", "detached", "segregated", "reclusive", "restrained", "broken", "unbalanced", "weak", "neutered", "disfigured", "spoiled", "damaged", "defective", "bizzare", "weird", "celibate", "powerless", "fruitless", "ruined", "bitter");

$connectors = array("and", "or", "vs");

function subjectText() {
	$string = $adjectives[rand(0, (count($adjectives)-1))]." ".$subjects[rand(0, (count($subjects)-1))];
	return $string ;
}

$nietscheQuotes = array (
	"He who laughs best today, will also laughs last.",
	"A friend should be a master at guessing and keeping still: you must not want to see everything.",
	"Wit is the epitaph of an emotion.",
	"When a hundred men stand together, each of them loses his mind and gets another one.",
	"What do I care about the purring of one who cannot love, like the cat?",
	"When marrying, ask yourself this question: Do you believe that you will be able to converse well with this person into your old age? Everything else in marriage is transitory.",
	"He who would learn to fly one day must first learn to stand and walk and run and climb and dance; one cannot fly into flying.",
	"In every real man a child is hidden that wants to play.",
	"The \"kingdom of Heaven\" is a condition of the heart - not something that comes \"upon the earth\" or \"after death.\"",
	"No one lies so boldly as the man who is indignant.",
	"If a woman possesses manly virtues one should run away from her; and if she does not possess them she runs away from herself.",
	"A woman may very well form a friendship with a man, but for this to endure, it must be assisted by a little physical antipathy.",
	"In Christianity neither morality nor religion come into contact with reality at any point.",
	"Our treasure lies in the beehive of our knowledge. We are perpetually on the way thither, being by nature winged insects and honey gatherers of the mind.",
	"What is good? All that heightens the feeling of power, the will to power, power itself in man.",
	"There is not enough religion in the world even to destroy religion.",
	"The best weapon against an enemy is another enemy.",
	"Rejoicing in our joy, not suffering over our suffering, makes someone a friend.",
	"Many a man fails as an original thinker simply because his memory it too good.",
	"All credibility, all good conscience, all evidence of truth come only from the senses.",
	"Faith: not wanting to know what is true.",
	"The doer alone learneth.",
	"Women can form a friendship with a man very well; but to preserve it - to that end a slight physical antipathy must probably help.",
	"One often contradicts an opinion when what is uncongenial is really the tone in which it was conveyed.",
	"Egoism is the very essence of a noble soul.",
	"Of all that is written, I love only what a person has written with his own blood.",
	"Necessity is not an established fact, but an interpretation.",
	"It says nothing against the ripeness of a spirit that it has a few worms.",
	"The true man wants two things: danger and play. For that reason he wants woman, as the most dangerous plaything.",
	"Whoever feels predestined to see and not to believe will find all believers too noisy and pushy: he guards against them.",
	"Once spirit was God, then it became man, and now it is even becoming mob.",
	"Character is determined more by the lack of certain experiences than by those one has had.",
	"In the consciousness of the truth he has perceived, man now sees everywhere only the awfulness or the absurdity of existence and loathing seizes him.",
	"You must have chaos within you to give birth to a dancing star.",
	"Words are but symbols for the relations of things to one another and to us; nowhere do they touch upon absolute truth.",
	"Whoever fights monsters should see to it that in the process he does not become a monster. And if you gaze long enough into an abyss, the abyss will gaze back into you.",
	"This is what is hardest: to close the open hand because one loves.",
	"Women are considered deep - why? Because one can never discover any bottom to them. Women are not even shallow.",
	"Whenever I climb I am followed by a dog called \'Ego\'.",
	"What doesn\'t kill us makes us stronger.",
	"When one has a great deal to put into it a day has a hundred pockets.",
	"Art is the proper task of life.",
	"What? You seek something? You wish to multiply yourself tenfold, a hundredfold? You seek followers? Seek zeros!",
	"There is not enough love and goodness in the world to permit giving any of it away to imaginary beings.",
	"One must still have chaos in oneself to be able to give birth to a dancing star.",
	"War has always been the grand sagacity of every spirit which has grown too inward and too profound; its curative power lies even in the wounds one receives.",
	"In individuals, insanity is rare; but in groups, parties, nations and epochs, it is the rule.",
	"We do not hate as long as we still attach a lesser value, but only when we attach an equal or a greater value.",
	"Admiration for a quality or an art can be so strong that it deters us from striving to possess it.",
	"A good writer possesses not only his own spirit but also the spirit of his friends.",
	"Nothing has been purchased more dearly than the little bit of reason and sense of freedom which now constitutes our pride.",
	"This is the hardest of all: to close the open hand out of love, and keep modest as a giver.",
	"I love those who do not know how to live for today.",
	"It is impossible to suffer without making someone pay for it; every complaint already contains revenge.",
	"There are no facts, only interpretations.",
	"He that humbleth himself wishes to be exalted.",
	"In praise there is more obtrusiveness than in blame.",
	"Many a man fails to become a thinker for the sole reason that his memory is too good.",
	"Love matches, so called, have illusion for their father and need for their mother.",
	"An artist has no home in Europe except in Paris.",
	"A subject for a great poet would be God\'s boredom after the seventh day of creation.",
	"It is not when truth is dirty, but when it is shallow, that the lover of knowledge is reluctant to step into its waters.",
	"Go up close to your friend, but do not go over to him! We should also respect the enemy in our friend.",
	"I cannot believe in a God who wants to be praised all the time.",
	"For art to exist, for any sort of aesthetic activity to exist, a certain physiological precondition is indispensable: intoxication.",
	"The surest way to corrupt a youth is to instruct him to hold in higher esteem those who think alike than those who think differently.",
	"The individual has always had to struggle to keep from being overwhelmed by the tribe. If you try it, you will be lonely often, and sometimes frightened. But no price is too high to pay for the privilege of owning yourself.",
	"There are horrible people who, instead of solving a problem, tangle it up and make it harder to solve for anyone who wants to deal with it. Whoever does not know how to hit the nail on the head should be asked not to hit it at all.",
	"To use the same words is not a sufficient guarantee of understanding; one must use the same words for the same genus of inward experience; ultimately one must have one\'s experiences in common.",
	"When you look into an abyss, the abyss also looks into you.",
	"The best author will be the one who is ashamed to become a writer.",
	"On the mountains of truth you can never climb in vain: either you will reach a point higher up today, or you will be training your powers so that you will be able to climb higher tomorrow.",
	"All truth is simple... is that not doubly a lie?",
	"Is life not a thousand times too short for us to bore ourselves?",
	"Ah, women. They make the highs higher and the lows more frequent.",
	"All things are subject to interpretation whichever interpretation prevails at a given time is a function of power and not truth.",
	"Many are stubborn in pursuit of the path they have chosen, few in pursuit of the goal.",
	"We love life, not because we are used to living but because we are used to loving.",
	"Art is not merely an imitation of the reality of nature, but in truth a metaphysical supplement to the reality of nature, placed alongside thereof for its conquest.",
	"Idleness is the parent of psychology.",
	"One has to pay dearly for immortality; one has to die several times while one is still alive.",
	"Let us beware of saying that death is the opposite of life. The living being is only a species of the dead, and a very rare species.",
	"When one does away with oneself one does the most estimable thing possible: one thereby almost deserves to live.",
	"That which does not kill us makes us stronger.",
	"Thoughts are the shadows of our feelings - always darker, emptier and simpler.",
	"Fear is the mother of morality.",
	"Before the effect one believes in different causes than one does after the effect.",
	"Insanity in individuals is something rare - but in groups, parties, nations and epochs, it is the rule.",
	"He who has a why to live can bear almost any how.",
	"These people abstain, it is true: but the bitch Sensuality glares enviously out of all they do.",
	"Whoever battles with monsters had better see that it does not turn him into a monster. And if you gaze long into an abyss, the abyss will gaze back into you.",
	"Although the most acute judges of the witches and even the witches themselves, were convinced of the guilt of witchery, the guilt nevertheless was non-existent. It is thus with all guilt.",
	"There are slavish souls who carry their appreciation for favors done them so far that they strangle themselves with the rope of gratitude.",
	"\'Evil men have no songs.\' How is it that the Russians have songs?",
	"It is always consoling to think of suicide: in that way one gets through many a bad night.",
	"Woman was God\'s second mistake.",
	"Fanatics are picturesque, mankind would rather see gestures than listen to reasons.",
	"One should die proudly when it is no longer possible to live proudly.",
	"People who have given us their complete confidence believe that they have a right to ours. The inference is false, a gift confers no rights.",
	"The future influences the present just as much as the past.",
	"The aphorism in which I am the first master among Germans, are the forms of \"eternity\"; my ambition is to say in ten sentences what everyone else says in a book - what everyone else does not say in a book.",
	"For the woman, the man is a means: the end is always the child.",
	"Undeserved praise causes more pangs of conscience later than undeserved blame, but probably only for this reason, that our power of judgment are more completely exposed by being over praised than by being unjustly underestimated.",
	"A great value of antiquity lies in the fact that its writings are the only ones that modern men still read with exactness.",
	"Shared joys make a friend, not shared sufferings.",
	"Anyone who has declared someone else to be an idiot, a bad apple, is annoyed when it turns out in the end that he isn\'t.",
	"Madness is rare in individuals - but in groups, parties, nations, and ages it is the rule.",
	"He who cannot give anything away cannot feel anything either.",
	"To be ashamed of one\'s immorality: that is a step on the staircase at whose end one is also ashamed of one\'s morality.",
	"There is an innocence in admiration; it is found in those to whom it has never yet occurred that they, too, might be admired some day.",
	"The press, the machine, the railway, the telegraph are premises whose thousand-year conclusion no one has yet dared to draw.",
	"Whoever despises himself nonetheless respects himself as one who despises.",
	"What can everyone do? Praise and blame. This is human virtue, this is human madness.",
	"Is man one of God\'s blunders? Or is God one of man\'s blunders?",
	"Nothing is beautiful, only man: on this piece of naivete rests all aesthetics, it is the first truth of aesthetics. Let us immediately add its second: nothing is ugly but degenerate man - the domain of aesthetic judgment is therewith defined.",
	"Do whatever you will, but first be such as are able to will.",
	"Not when truth is dirty, but when it is shallow, does the enlightened man dislike to wade into its waters.",
	"All sciences are now under the obligation to prepare the ground for the future task of the philosopher, which is to solve the problem of value, to determine the true hierarchy of values.",
	"There is always some madness in love. But there is also always some reason in madness.",
	"Sleeping is no mean art: for its sake one must stay awake all day.",
	"He who has a strong enough why can bear almost any how.",
	"Stupid as a man, say the women: cowardly as a woman, say the men. Stupidity in a woman is unwomanly.",
	"Whoever has witnessed another\'s ideal becomes his inexorable judge and as it were his evil conscience.",
	"I would believe only in a God that knows how to Dance.",
	"Plato was a bore.",
	"There cannot be a God because if there were one, I could not believe that I was not He.",
	"The word \"Christianity\" is already a misunderstanding - in reality there has been only one Christian, and he died on the Cross.",
	"The irrationality of a thing is no argument against its existence, rather a condition of it.",
	"In everything one thing is impossible: rationality.",
	"Judgments, value judgments concerning life, for or against, can in the last resort never be true: they possess value only as symptoms, they come into consideration only as symptoms - in themselves such judgments are stupidities.",
	"It is the most sensual men who need to flee women and torment their bodies.",
	"There are various eyes. Even the Sphinx has eyes: and as a result there are various truths, and as a result there is no truth.",
	"What do you regard as most humane? To spare someone shame."
);

$dirPath = 'strips/';

$ext = "png";

$width = 501;
$height = 169;

function getImagePool() {

global $dirPath;
global $ext;

if (is_dir($dirPath)) {

if ($dh = opendir($dirPath)) {

	//error_reporting(E_ALL ^ E_WARNING);


	$dexext = "/\.".$ext."\Z/";

	while (($filename = readdir($dh)) !== false) {

		if(getimagesize($dirPath.$filename)) {
			if (strpos($filename, "a.png")) {
				$imgSrc[0][count($imgSrc[0])] = preg_replace($dexext, "", $filename);
			} else if (strpos($filename, "b.png")) {
				$imgSrc[1][count($imgSrc[1])] = preg_replace($dexext, "", $filename);
			} else if (strpos($filename, "c.png")) {
				$imgSrc[2][count($imgSrc[2])] = preg_replace($dexext, "", $filename);
			}
		}
	}}
}

return $imgSrc;

}

function getUrlString($imgSrc) {

	return preg_replace("/=/", "", base64_encode($imgSrc[0][rand(0, (count($imgSrc[0])-1))].'|'.$imgSrc[1][rand(0, (count($imgSrc[1])-1))].'|'.$imgSrc[2][rand(0, (count($imgSrc[2])-1))]));

}

?>