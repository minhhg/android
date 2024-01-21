## Introduction
This is my very old Android project (2013-2014) for News Reading App, called  aNewsReader.
Allow you to manage News websites and reading (audio). It is very basic and was
developed using App Inventer (https://ai2.appinventor.mit.edu/) so do not expect a perfect app. 
I shared here for any people interested to develop it further. 

## How to quick set up and run
1. Install the app: download **aNewsReader.apk** and install on your android phone.
2. Set up text extract server.
   You need to set up a webserver to extract text from news website.
   ### Install webserver on ubuntu for Read News (audio) function only
   sudo apt install apache2
   
   sudo apt install php libapache2-mod-php #Install PHP
   
   sudo cp index.php /var/www/html/
   
   sudo systemctl restart apache2.service
   
## Run text parser service
   on the same server run:
   
   **java -jar newsextract.jar**
   
   
  
## How does it work?
When user request Read (text -> audio), the Android app will send the url to the websever,
the script (index.php) is executed, which will connect to localhost on port 4444 
(newsextract.jar) to extract text only from (xml, html) and send it back to the Android app.
The Android app calls text-speak to turn it to audio.


## Notes

  If you only need to run locally, you can set up all the above on your pc/laptop. 
  However if you want to access the Read (audio) function anywhere, you need to install them 
  on a server which can be accessed from the Internet.

  If you are an advanced Java/Android app developer, you can integrate them into 1 app without 
  needing any extra server. The library java codes are suppied, this is old version. 
  You can get the latest version from Internet. Please also read the LICENSE.txt carefully for 
  **boilerpipe**.
   
   
## First time running the app
   In the first text box: you enter "http://192.168.1.10/index.php?url=", 
   where 192.168.1.10 is your server ip address, then press Setup.
   After that you can enter any news website and press go, then Read if you want to hear audio.

If you have any question, please email me at minh.scholar at gmail.com.