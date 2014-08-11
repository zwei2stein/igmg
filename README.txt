Notes:

 - mobile app depends on deployed weabsite json api, you might want to change
   cz.zweistein.android.infinitegarfieldminusgarfield.Configuration.BASE_URL to your own location

 - website needs comic strip frames in /strips directory xxxxa.png, xxxxb.png and xxxxc.png
   xxxx is number of comic. Put there anything you want

 - In order to create strips, there is small tool to help you, run cz.zweistein.garfield.PictureParser
   before that, you need to edit baseIndex value (famre number of first outputed frame, further frames are
   numbered sequentially) and put comic strips to input folder. Cut frames are in output directory.