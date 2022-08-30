# NYNews
NyNews is an Android Application , which lists the most viewed news from the NewYork Times.
The App will show the cached News in case it fails to load the data from the server.
Since the Api needs subscription, there is only limited access to the data.

Anyway the applications main aim is to showcase the latest Architecture patterns, usage of Jetpack libraries etc.
Since the UI design is not our concern, I didn't focus much on the screen Design.

## Screenshots

![Screenshot showing For News listing screen](doc/images/screenshot_dark.png "Screenshot showing For News listing screen")
![Screenshot showing For News listing screen](doc/images/screenshot_light.png "Screenshot showing For News listing screen")
![Screenshot showing For News Detail screen](doc/images/screenshot_detail_dark.png "Screenshot showing For News Detail screen")
![Screenshot showing For News Detail screen](doc/images/screenshot_detail_light.png "Screenshot showing For News Detail screen")


## To build the Application :

You can clone or download the code from here :

https://github.com/JovinPJ/NYNews.git

Once the code is available in your machine, you can open it using Android studio. App code is available inside the subfolder - '/NyNews'. So you may need to navigate to the specified subfolder, while opening the Application in Android studio, before selecting the path.
API_KEY to fetch the api is not masked, so that one can easily build and run the app.

## To Test the Application :

There is a Gradle Task available named `testDebugUnitTestCoverageVerify`. We need to run that task using the command
`./gradlew testDebugUnitTestCoverageVerify`, It will show the total test coverage percentage in the build console, after task successfully 
completed, like this `Test coverage: 73%`.
The test details also can be found in browser by opening these html files : 

 - build/reports/tests/testDebugUnitTest/index.html
 - build/reports/jacoco/testDebugUnitTestCoverage/html/index.html

To run the Gradle task we can better use Android Studio Terminal.