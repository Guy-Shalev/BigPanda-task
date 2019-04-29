# BigPanda-task


/********************************************************************/

			INSATUCTIONS

1. Get the code from GitHub https://github.com/Guy-Shalev/BigPanda-task 

2. In src\main\java\com\BigPanda\BigPandatask\service.EventGenerator.java replace the ProcessBuilder path to where the blackbox executable exists on your local machine.

3. Run the code (i used intellij).

4. Go to http://localhost:8080/api/getTaskResponse, and refresh the page each time you want to see the current data.

5. Note that the provided blackbox executable creates events slowly, so it may take several refreshes to the web page to show the data.

/********************************************************************/

		IMPROVEMENTS FOR THE FUTURE

1. I would create a website that shows the data updated in real time.

2. I would implement other technologies like Akka, to make the system more scaleable and alow it to process larger amounts of data.

3. I would manage a database in order to keep statistics on incomming events and expose an http API for that.

4. I would allow the program to read the location of the blackbox executable from an external file.
README .txt
Displaying README .txt.
