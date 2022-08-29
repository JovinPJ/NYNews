# NYNews
NyNews is an Android Application , which lists the most viewed news from the NewYork Times.
The App will show the cached News in case it fails to load the data from the server.
Since the Api needs subscription, there is only limited access to the data.

Anyway the applications main aim is to showcase the latest Architecture patterns, usage of Jetpack libraries etc.
Since the UI design is not our concern, I didn't focus much on the screen Design.


## To build the Application :

You can clone or download the code from here :

https://github.com/JovinPJ/NYNews.git

Once the code is available in your machine, you can open it using Android studio. App code is available inside the subfolder, '/NyNews', so you may need to navigate to the specified subfolder, before selecting the path, while opening the Application in Android studio.
API_KEY to fetch the api is not masked, so that one can easily build and run the app.

## To Test the Application :

There is a Gradle Task available named 'jacoco'. We need to run that task to test the application, it also shows the total test coverage after successfully
completing the Gradle task in the file '/jacoco/'. To run the Gradle task we can better use Android Studio Terminal.
