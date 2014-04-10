cuke-jvm-sample
===============


A sample Test Automation Framework to understand and use cucumber-jvm

---------------


## What is implemented in this sample Test Automation Framework?

* Tests specified using [cucumber-jvm](http://cukes.info/install-cucumber-jvm.html)
* Build tool: [Gradle](http://gradle.org/)
* Programming language: [Groovy (for Gradle)](http://groovy.codehaus.org/) and Java
* Test Data Management: Samples to use data-specified in feature files, AND use data from separate json files
* Browser automation: Using [WebDriver](http://code.google.com/p/selenium/wiki/GettingStarted) for browser interaction
* Web Service automation: Using [cxf library](http://cxf.apache.org/) to generate client code from web service WSDL files,
and invoke methods on the same
* Take screenshots on demand and save on disk
* Integrated [cucumber-reports](https://github.com/masterthought/cucumber-reporting) to get 'pretty' and 'meaningful' reports from test execution
* Using [apache logger](http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/Logger.html) for storing test logs in files (and also report to console)
* Using [aspectJ](http://eclipse.org/aspectj/) to do byte code injection to automatically log test trace to file. Also creating a separate benchmarks file to track time taken by each method. This information can be mapped separately in other tools like Excel to identify patterns of test execution.

---------------


## Usage Steps:

### Install / configure Gradle:

**Gradle 1.11** - download from [here](http://www.gradle.org/downloads). See installation steps [here](http://www.gradle.org/installation).

(You can use homebrew to install, or IntelliJ should be able to install for you)

JVM:          1.6.0_65 (Apple Inc. 20.65-b04-462)

OS:           Mac OS X 10.9.1 x86_64

### IntelliJ IDEA

* Import the existing folder into IntelliJ and it should ask you to set your JDK and Gradle and you should be able to use IntelliJ.
* Once opened, you will want to install the 'Cucumber for Java' plugin from the Jetbrains repository which gives you syntax highlighting and ability to jump to steps.

### Dependent libraries

All other dependent libraries are checked into the lib folder

### Running sample tests

#### To run Cucumber tests
    gradle clean cucumber

#### To create Java classes from WSDLs
    Specify the Web Service name + WSDL url in the wsdlList method in build.gradle file
    Run the command:
        gradle clean buildWSClients
    This command created Java classes for the specified WSDLs in the build/WebServiceClients directory
    Once created, manually move these classes to the package of choice
        - I have moved the curencyConvertor and the globalWeather clients to src/main/java/flows package
    Update the package in all the client files after moving them in the new location
    Compile the code to ensure there is no file left from updating the package



### Reports

Cucumber-html and junit reports are generated and available in

    build/reports

## Contact

For any information about this sample project, send an email to abagmar@gmail.com

---------------