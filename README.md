cuke-jvm-sample
===============

A sample repo to understand and use cucumber-jvm

## Usage Steps:
---------------

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
