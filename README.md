### ATCommandTester

#### NOTE: This repo is just for reference to the old application code, it's not actively maintained or supported.

---

`Test AT commands for GSM modems over serial (RS232/UART) connection with lots of options.`

* Ported and cleaned up version of the ATCommandTester from m2msupport.net
* Standalone & offline - no Java Applet security bullshit
* Still lots of optimizations can be done, e.g. ATCommandTester.java >10k lines!!! seriously?! OMG!
* Grab and enjoy!

***Windows users***

`Run run_x32.bat file to launch the program on 32-bit Windows.`

`Run run_x64.bat file to launch the program on 64-bit Windows.`

***GNU/Linux users***

Install the Java Runtime Environment (JRE) and the java package for `RXTXComm.jar`

I.e: in Ubuntu GNU/Linux:

`sudo apt install openjdk-11-jre` for the JRE, if you don't have the command `java`

and

`sudo apt install librxtx-java` for the RXTXcomm library.

After that you can run the program with the right permissions to write to your serial port.

If you are in doubt... just use sudo ;)

`sudo java -jar ATCommandTester.jar`

***Screenshots***

<img src="img/screen1.png" width="500">
