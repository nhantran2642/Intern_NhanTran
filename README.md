# **SELENIUM AUTOMATION TESTING**

### OVERVIEW

*This is my project in my automation testing internship course 2024 at [AGEST DANANG](https://www.agest.vn/).*

The purpose of this project to learn about how to build an automation framework by using Selenium.

My project applies the POM framework in Selenium and uses Java as the scripting language. Maven is used for dependency management and continuous development. TestNG is used to maintain test cases. Extent Report is used to report the result of the test suite. A simple Selenium Grid is implemented to run tests in parallel on different browser.

*AUT: [Safe Railway](http://saferailway.somee.com/)*

### TABLE OF CONTENTS
* [OVERVIEW](#OVERVIEW)  
* [TECHNOLOGIES & FRAMEWORK](#TECHNOLOGIES-AND-FRAMEWORK)
* [INSTALLATION](#INSTALLATION) 
* [FOLDER USAGE](#FOLDER-USAGE) 
* [TEST RUNNING](#TEST-RUNNING) 

### TECHNOLOGIES AND FRAMEWORK
* Java 11
* Selenium 4.21.0
* Selenium Grid 4.21.0
* IntelliJ IDEA
* Maven 
* TestNG 
* Extent Reports
* POM (Page Object Models)

### INSTALLATION

* Clone the repository: 

``` bash
git clone https://github.com/tranthanhnhan2604/Intern_NhanTran.git
```

* Open project on IntelliJ IDEA or another IDEA.

### FOLDER USAGE

* **src/main/java**: Contains main code for POM framework.
    * common: Define constant variables.
    * enums: Define enum classes for selections in AUT.
    * models: Define objects.
    * pages: Define all elements and method using into each page.
    * utils: Define wrapper classes of control in AUT, helper classes, management classes(Logger, Driver, File Reader).
* **src/main/resources**: Contains files for running grid and json file which storing data for test.
* **src/test/java**: Contains test code.
    * base: Test base class
    * chapter10: Test cases.
    * listeners: TestNG listeners uses for repoting.
* **src/test/src**: Contains .xml file for TestNG and Log4j configuration.

### TEST RUNNING
...
