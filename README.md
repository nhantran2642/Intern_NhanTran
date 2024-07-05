# **SELENIUM LV1 AUTOMATION TESTING COURSE**

### OVERVIEW

*This is my personal project in my automation testing internship course 2024 at [AGEST VIETNAM](https://www.agest.vn/).*

The purpose of this project is to learn about how to build an automation testing framework by using Selenium.

My project applies the POM framework in Selenium and uses Java as the scripting language. Maven is used for dependency management and continuous development. TestNG is used to maintain test cases. Extent Report is used to report the result of the test suite. A simple Selenium Grid is implemented to run tests in parallel on different browser.

*AUT: [Safe Railway](http://saferailway.somee.com/)*

### TABLE OF CONTENTS
* [OVERVIEW](#OVERVIEW)  
* [TECHNOLOGIES & FRAMEWORK](#TECHNOLOGIES-AND-FRAMEWORK)
* [INSTALLATION](#INSTALLATION) 
* [FOLDER USAGE](#FOLDER-USAGE) 
* [TEST RUNNING](#TEST-RUNNING)
* [AUTHOR & SUPPORTERS](#AUTHOR) 

### TECHNOLOGIES AND FRAMEWORK
* Java 11
* Selenium 4.21.0
* Selenium Grid 4.21.0
* IntelliJ IDEA
* Maven 
* TestNG 
* Extent Reports
* POM (Page Object Models)
* Data Driven

### INSTALLATION

* Clone the repository: 

``` bash
git clone https://github.com/tranthanhnhan2604/Intern_NhanTran.git
```

* Open project on IntelliJ or another IDE.

### FOLDER USAGE

* **src/main/java**: Contains main code for POM framework.
    * common: Define constant variables.
    * enums: Define enum classes for selections in AUT.
    * models: Define objects.
    * pages: Define all elements and methods used on each page.
    * utils: Define wrapper classes of control in AUT, helper classes, and management classes(Logger, Driver, File Reader).
* **src/main/resources**: Contains files for running grid and JSON file storing data for test.
* **src/test/java**: Contains test code.
    * base: Test base class
    * chapter10: Test cases.
    * listeners: TestNG listeners are used for reporting.
* **src/test/src**: Contains .xml file for TestNG and Log4j configuration.

### TEST RUNNING
There are 2 ways to run this project:

1. Run on local

    * Go to the configuration file of TestNG in path ```src\test\java\src\testng.xml``` and change the value of the parameter **runMode** to *"local"*.

    * Select the test cases you want to run in this file.

    * Right click anywhere on file ```testng.xml``` and select ```Run '\src\test\java\src\testng.xml'``` to run test scripts.

2. Run on grid

    * Go to the configuration file of TestNG in path ```src\test\java\src\testng.xml``` and change the value of the parameter **runMode** to *"grid"*.

    * Go to the folder ```src\main\resources\grids```, and make sure the file ```selenium-server-4.21.0.jar``` exists in this folder, if not, you can download it at [here](https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.21.0/selenium-server-4.21.0.jar) and save it in this folder.

    * Run respectively two .bat file ```selenium-grid-hub.bat``` and ```selenium-grid-node.bat```.

> Note:
> 
> * In case you want to run test scripts in different browsers, you can config file ```testng.xml``` as
>
> ```<parameter name="browser" value="chrome"/>``` with the value is ```chrome```, ```firefox``` or ```edge```
>
> * In case you want to run test scripts in parallel, you can config file ```testng.xml``` as
>
> ```<suite name="RegressionSuite" verbose="1" parallel="classes" thread-count="1">```


## AUTHOR

- [@tranthanhnhan2604](https://www.github.com/tranthanhnhan2604)

## SUPPORTERS

- [@vihoang0706](https://github.com/vihoang0706)
- [@HoaiLinh0908](https://github.com/HoaiLinh0908)
