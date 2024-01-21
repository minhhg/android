# !/usr/bin/perl
system("cd /home/inf/Projects/NewsExtract/boilerpipe-1.2.0/src/demo");
system("java -classpath /home/inf/Projects/NewsExtract/boilerpipe-1.2.0/boilerpipe-1.2.0.jar:/home/inf/Projects/NewsExtract/boilerpipe-1.2.0/lib/nekohtml-1.9.13.jar:/home/inf/Projects/NewsExtract/boilerpipe-1.2.0/lib/xerces-2.9.1.jar:. de.l3s.boilerpipe.demo.Oneliner http://www.bbc.co.uk/news/world-middle-east-20945837#sa-ns_mchannel=rss\&ns_source=PublicRSS20-sa")
