<?php
$url = $_GET['url'];

error_reporting(E_ALL);

/* Get the port for the WWW service. */
$service_port = 4444;

/* Get the IP address for the target host. */
$address = gethostbyname('localhost');

/* Create a TCP/IP socket. */
$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
if ($socket === false) {
	echo "socket_create() failed: reason: " .
			socket_strerror(socket_last_error()) . "\n";
}

# echo "Attempting to connect to '$address' on port '$service_port'...";
$result = socket_connect($socket, $address, $service_port);
if ($result === false) {
	echo "socket_connect() failed.\nReason: ($result) " .
	socket_strerror(socket_last_error($socket)) . "\n";
}

	
$in = "Host: www.example.com\r\n";
# $in .= "Connection: Close\r\n\r\n";
$out = '';


#	echo "Sending HTTP HEAD request...";
$url .= "\n";	
#echo $url;
socket_write($socket, $url, strlen($url));
#  echo "OK.\n";

# echo "Reading response:\n\n";
$sect_len = 400; #average length of section
$cur_pos = 0; 
while ($out = socket_read($socket, 2048)) {
	if (strlen($out) > $sect_len) {
		$pos = strpos ($out, ".", $sect_len);
	}
echo $out;
}

	socket_close($socket);

?>
