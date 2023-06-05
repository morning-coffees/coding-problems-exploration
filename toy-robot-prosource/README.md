# toy-robot-prosource

Coding Challenge from ProSource  
The Toy Robot is based on a blog post by Jon Eaves. Read it here
https://joneaves.wordpress.com/2014/07/21/toy-robot-coding-test/
<br /><br />

# Prerequisites

Make sure you have Java and Eclipse installed.
- Java Download: https://www.oracle.com/java/technologies/downloads/ (download the latest java version)
- Eclipse Download: https://www.eclipse.org/downloads/


# Running the Project
1. Clone the project in git
2. checkout command-pattern-TDD branch: `git checkout command-pattern-TDD`
3. Import the project in eclipse (or your favorite IDE)
4. In eclipse, Right click the project folder in eclipse, `RUN AS` > `Java Application`
    - It is a basic java project and should run without any additional installation since it does not have any dependencies.

# Running the test
1. Right click on the test source folder `src/test/java`
2. Hover `RUN AS` > `Junit Test`


# Using the application
The application will print after every command so the user can track the progress of the robots.

1. Program will ask the number of columns and rows provide the column and rows to initialize the table  
`Table # columns: ` example: 5  
`Table # rows: ` example: 5 
2. Program will ask how many robots, provide N number of robots  
`How many robots?` example: 2  
3. Program will ask the details of robots, provide the details of the robot  
Directions: NORTH,SOUTH,EAST,WEST  
`Robot 1 Details (PLACE x,y,DIRECTION):` example: PLACE 0,0,NORTH
4. Program will ask the commands:  
`Available Commands: MOVE,LEFT,RIGHT,REPORT,END`  
`Enter Command (COMMAND ROBOTNUMBER):` example: MOVE 1  
5. To exit, enter command `END`