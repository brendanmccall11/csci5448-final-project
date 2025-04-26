# CSCI 5448: Object-Oriented Analysis & Design - Graduate Project
## University of Colorado - Boulder
## Authors: Brendan McCall & Carlina Wharton-Bucher

In this project we look at how Java and Kotlin can create polygons 
and use the edge flip algorithm described in the corresponding paper.
There are two drivers which calculate the average run time of creating
a polygon and running through the algorithm previously mentioned.

### Dependencies

- Intellij (IDE)
- Gradle (Build Tool)
- JUnit (Testing)
- Kotlin Standard Library
- Java Standard Library
- Java.awt.Polygon

### Build Instructions

Use IntelliJ Idea to open the project after cloning it. If prompted
by gradle to load the project, do so. Otherwise, in the root directory
of the project type the following:

```
gradle clean
gradle build
```
Finally, you can press the run button next to the main function in the
driver that you wish to run.

### Test Instructions

In each test file you can run each test function individually, or
right-click on the "Test" directory and choose the run tests option
to run all tests at once.