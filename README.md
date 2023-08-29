## Test description
The point of this test is to determine whether the capabilities of generative AI could benefit the programmers in there day to day life. 

This may include: 
* configuring the simple CI/CD jobs to check code quality
* writing unit tests: both simple and complex
* potentially implementing a minor tickets that may include 1-2 code changes in the code base

## How to run tests locally
In order to execute the unit tests locally, you would need to do the following steps:
1. Clone the repository to your local machine
```
git clone https://github.com/Non-profitable-memable-org/use-case-7-org.git
```
OR if you are using SSH
```
git clone git@github.com:Non-profitable-memable-org/use-case-7-org.git
```
2. Install Maven to your local machine. Please refer to official installation guide: https://maven.apache.org/install.html
3. Navigate from terminal to the root folder of this project (you can say if it is the root if:
In case of Linux/MacOS:
```
ls
```
For Windows: 
```
dir
```
command includes pom.xml file.

4. Run in terminal 
```
mvn clean install test
```
