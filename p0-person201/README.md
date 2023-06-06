# Project 0: Person201

This project uses a `Person201` class to keep track of data about many individuals. We will use this along with static utility methods from `Person201Utilities` and main/driver methods from `Person201Demo` and `Person201Finder` to search for individuals in Compsci 201 who are near each other on campus. You may be surprised how many classmates you find live or hang out near you! 

## Outline
- [Goals](#goals)
- [Starter Code and Using Git](#starter-code-and-using-git)
- [Coding in Project P0: Person201](#coding-in-project-p0-person201)
    - [Run Person201Demo](#run-person201demo)
    - [Fix Person201](#fix-person201)
    - [Interlude: Understanding Multi-file Programs](#interlude-understanding-multi-file-programs)
    - [Fix sameFloor in Person201Utilities](#fix-samefloor-in-person201utilities)
    - [Checking sameFloor Methods](#checking-samefloor-methods)
    - [Create and Run Person201Finder](#create-and-run-person201finder)
- [Analysis Questions](#analysis-questions)
- [Submission and Grading](#submission-and-grading)


## Goals

* Practice the workflow of a project in CompSci201
* See, edit, and run a multi-file Java program
* Create a Java class from scratch that is used by other Java classes
* Read data from a file in Java
* Practice introductory object-oriented programming
* Learn about using Git for project management.


## Starter Code and Using Git
**_You should have installed all software (Java, Git, VS Code) before completing this project._** You can find the [directions for installation here](https://coursework.cs.duke.edu/cs-201-spring-23/resources-201/-/blob/main/installingSoftware.md) (including workarounds for submitting without Git if needed).

We'll be using Git and the installation of GitLab at [coursework.cs.duke.edu](https://coursework.cs.duke.edu). All code for classwork will be kept here. Git is software used for version control, and GitLab is an online repository to store code in the cloud using Git.

**[This document details the workflow](https://coursework.cs.duke.edu/cs-201-spring-23/resources-201/-/blob/main/projectWorkflow.md) for downloading the starter code for the project, updating your code on coursework using Git, and ultimately submitting to Gradescope for autograding.** We recommend that you read and follow the directions carefully this first time working on a project! While coding, we recommend that you periodically (perhaps when completing a method or small section) push your changes as explained in Section 5.


## Coding in Project P0: Person201

When you fork and clone the project, **make sure you open the correct project folder in VS Code** following the [directions shown here](https://coursework.cs.duke.edu/cs-201-spring-23/resources-201/-/blob/main/projectWorkflow.md#step-3-open-the-project-in-vs-code).

You will be working primarily with the `.java` files in the `src` folder beginning with `Person201.java`. You will modify two programs/classes (`Person201.java` and `Person201Utilities.java`), and will run `Person201Demo.java` to see if your changes are working. Then you will create a new program called `Person201Finder.java`.

The following subsections sections detail the specific action items you should take while completing this project.

### Run Person201Demo

First, without changing anything, run the main method in `Person201Demo.` The output of the program (not counting terminal commands to compile and run the program) should be:

```
Searching for people near Fain

People on the same floor: 

People in the same building: 
        -Wiseman, LSRC, 1
        -Astrachan, LSRC, 2
        -Stephens-Martinez, LSRC, 2
```


Take a careful look at the main method you just ran. Note that it creates `Person201` **objects**. Those are defined in the `Person201` **class**, which you can see in the `Person201.java` file. You can also see that it reads data about persons from a file by calling the static `readFiles` method defined in `Person201Utilities.java`. The particular file, `small.txt`, contains data about a few of your professors and their office locations; the file is in the `data` folder of your project and you can view it directly in Visual Studio Code.

The main method you ran from `Person201Demo` is *supposed* to define a query person and then search for all other persons in the provided data file `small.txt` that are on the same floor of the building or at least in the same building, and print those lists to the screen. You can already see that something is not quite right: `Wiseman, LSRC, 1` is on the same floor (`1`) of the same building (`LSRC`) as the query person `Fain, LSRC, 1`, but is not printed under the heading `People on the same floor:`. Your first two tasks will be to fix this.

### Fix Person201

Take a look at the `Person201.java` file. This is the class that defines `Person201` objects. Note the **instance variables** defined first outside of any methods - every `Person201` object has a value for each of these that can be accessed with the `.` operator. Two constructors, one default and one with initial data, are then provided for creating `Person201` objects. Finally, a number of other public and *not* static methods are defined - these are methods other code can call on `Person201` objects using the `.` operator.

You will see a TODO written in a comment before the `sameFloor` method. Modify this method so that it returns `true` if the parameter `other` object has the same `myBuilding` and `myFloor` values as `this` object. Feel free to use the correctly implemented `sameBuilding` method as a *helper method* to determine if they have the same building.

### Interlude: Understanding Multi-file Programs

After fixing the `sameFloor` method of `Person201`, try running the main method of `Person201Demo` again. You should notice...no change! What gives?

Most software consists of **many** different files, each organized into smaller units called `methods` in Java (or functions in other languages). This practice helps us to keep code organized into comprehensible units. 

For this project, `Person201.java` defines `Person201` objects (what data they hold and what basic operations they support), `Person201Utilities.java` defines static methods that do things having to do with multiple `Person201` objects, and `Person201Demo.java` uses `Person201` objects and `Person201Utilities` methods to search for nearby people given a data source. Fixing `Person201` doesn't completely address the problem with `Person201Demo` because it actually calls a method from `Person201Utilities`, namely the `sameFloor` method. Next we will fix that method.

### Fix sameFloor in Person201Utilities

Take a look at the `Person201Utilities.java` file. Note that there are no instance variables and all of the methods are static. You can see the usage of these methods in `Person201Demo.java`.

You will see a TODO written in a comment before the `sameFloor` method. Note that this method has the same name as the one you edited in `Person201` but they are quite different. This one takes as input an **array** of `Person201` objects called `people` plus another separate single `Person201` object called `person`. It should return a `List` of `Person201` objects containing all `Person201` objects in `people` that are not exactly equal to `person` but have the same value of `myFloor` and `myBuilding` as `person`.

You can model your solution off of the `sameBuilding` method implemented above, and may wish to use the dynamic `sameFloor` method of the `Person201` class you wrote previously as a helper.

### Checking sameFloor Methods

When you have finished fixing the `sameFloor` method in both `Person201.java` and `Person201Utilities.java`, again run the main method of `Person201Demo`. You should now see the following output (again ignoring the terminal commands to compile and run the code):

```
Searching for people near Fain

People on the same floor: 
        -Wiseman, LSRC, 1

People in the same building: 
        -Wiseman, LSRC, 1
        -Astrachan, LSRC, 2
        -Stephens-Martinez, LSRC, 2
```

### Create and Run Person201Finder

The main method of `Person201Demo.java` only searches for nearby people in the `small.txt` file of the data folder. In this part, you will write a new class with a new main method that searches for people who are nearby to *you* from a larger data file `people.txt` that is stored on the internet.

In the `src` folder create a new file named `Person201Finder.java` (it needs to have exactly that name, case sensitive!). Create a single `public` class named `Person201Finder` (again, exactly that name). Inside the class, create a single `public static void main(String[] args)` method. 

The main method you write should create a `Person201` object that contains information about yourself, see the creation of `query` in `Person201Demo` for an example. Put a name (or nickname, or whatever you like), then a building you spend time in, then a floor number for that building.

Next, generate an array of `Person201` objects generated by reading the data located at the following url: `https://courses.cs.duke.edu/compsci201/spring23/notes/people.txt`. To do so, use the static method `readURL` from `Person201Utilities.java`. Next, find and print all of the `Person201` objects from the data file who are not equal to yourself but are on the same floor of the same building, and separately those who are in the same building. You can use additional methods from `Person201Utilities` to accomplish this. See `Person201Demo` for a very similar example to what you should write.

When you have finished, run the main method of your new `Person201Finder` class. If everything is correct, you should see printed all of the people from the `people.txt` data file on the internet who are in the same building and/or floor number as you. Hopefully you will learn something about a nearby classmate!


## Analysis Questions

Answer the following questions in your analysis. You'll submit your analysis as a separate PDF as a separate assignment ***to Gradescope***. 

### Question 1
- How many instance variables are there in `Person201`?
- How many constructors are there in `Person201`?

### Question 2
According to the `equals` method of the `Person201` class, when are two `Person201` objects considered to be equal? Is it case sensitive for their names or for the names of their buildings?

### Question 3
Does the main method of `Person201Demo` create any objects of type `Person201Utilities`? If so, why? If not, why is this not necessary?

### Question 4
Note that your `Person201Finder.java` program did not need any kind of password to automatically pull data from the `people.txt` file; it is publicly available on the internet. In one or two paragraphs, reflect on and respond to one or more of the following related questions. This question is graded for honest effort, not correctness.
- Do you think it's a good idea to keep information about individuals publicly available on the internet? What are some pros and cons?
- If you were the designer of a web application that included personal information (such as a social media app), how would you protect the privacy of your users?

***After completing the analysis questions you submit your answers in a PDF to Gradescope in the appropriate assignment.***

## Submission and Grading
You will submit the assignment on Gradescope. You can access Gradescope through the tab on Sakai. The [project workflow writeup](https://coursework.cs.duke.edu/cs-201-spring-23/resources-201/-/blob/main/projectWorkflow.md) explains the how to submit your project in detail. Be sure to push changes often and be sure your final program is in your Git repository before you submit it for autograding on Gradescope. Please take note that changes/commits on GitLab are NOT automatically synced to Gradescope. You are welcome to submit as many times as you like, only the most recent submission will count for a grade.
