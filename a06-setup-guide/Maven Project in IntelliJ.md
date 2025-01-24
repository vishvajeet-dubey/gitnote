1.) Open IntelliJ   

2.) Create New project
![](resources/Pasted%20image%2020241211235858.png)   


3.) Create Java Maven Project   
![](resources/Pasted%20image%2020241212000239.png)   


4.) Add Scala dependency into pom.xml file   
- Below dependency need to add in pom.xml file
```xml
<dependencies>    <!-- https://mvnrepository.com/artifact/org.scala-lang/scala-library -->  
  <dependency>  
    <groupId>org.scala-lang</groupId>  
    <artifactId>scala-library</artifactId>  
    <version>2.11.12</version>  
  </dependency>  <!-- ADD OTHER DEPENDENCY -->  
  
</dependencies>
```

- Final dependency pom.xml file
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
  <modelVersion>4.0.0</modelVersion>  
  
  <groupId>org.example</groupId>  
  <artifactId>scalaMavenPro</artifactId>  
  <version>1.0-SNAPSHOT</version>  
  
  <properties>    <maven.compiler.source>8</maven.compiler.source>  
    <maven.compiler.target>8</maven.compiler.target>  
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
  </properties>
  
  <dependencies>    <!-- https://mvnrepository.com/artifact/org.scala-lang/scala-library -->  
    <dependency>  
      <groupId>org.scala-lang</groupId>  
      <artifactId>scala-library</artifactId>  
      <version>2.11.12</version>  
    </dependency>  
    <!-- ADD OTHER DEPENDENCY -->  
  
  </dependencies>  
  
</project>
```


5.) Rename java to scala   
![](resources/Pasted%20image%2020241212001232.png)   
![](resources/Pasted%20image%2020241212001350.png)   


6.) Click on the project name and double click "Shift" button to get search bar and search for "add framework support".   
![](resources/Pasted%20image%2020241212002607.png)   
6.1) select the scala and version according the pom.xml and add the version. Once added check the external libraries, scala version should be added in it.   
![](resources/Pasted%20image%2020241212003208.png)   


7.) Create package under main/scala "org.leaning"   
![](resources/Pasted%20image%2020241212003653.png)   


8.) Create scala Object called Main under main/scala/org/learning   
![](resources/Pasted%20image%2020241212003828.png)   


9.) Write the sample code and run it.   
![](resources/Pasted%20image%2020241212003954.png)   
![](resources/Pasted%20image%2020241212004015.png)   


10.) Now click on Maven and run clean    
![](resources/Pasted%20image%2020241212004841.png)   
![](resources/Pasted%20image%2020241212004931.png)   
![](resources/Pasted%20image%2020241212005020.png)   


11.) Now click on Maven and run install.


12.) Once clean success then right click on project > open module settings > Artifacts and add Artifacts.   
![](resources/Pasted%20image%2020241212005300.png)   
12.1) Click on plus icon and follow below   
![](resources/Pasted%20image%2020241212005415.png)   
12.2) Select main class and then click on ok   
![](resources/Pasted%20image%2020241212005540.png)   
12.3) Change to folder to target instead of out and click on apply and ok   
![](resources/Pasted%20image%2020241212005956.png)   
From above keep only one jar(2nd one) under scalaMavenPro.jar section.   


13.) Now click on Maven and run clean again as step 10 to delete the target folder.  

14.) Click on Left corner 3 line and go to build section   
![](resources/Pasted%20image%2020241212010510.png)    
14.1) Build > Build Artifacts...   
![](resources/Pasted%20image%2020241212010613.png)   
14.2) Once click on build artifacts then below window will open then click on Build and wait for build to complete 
![](resources/Pasted%20image%2020241212010915.png)   



15.) After this Build success prompt will come and target folder will create and jar with dependency will create under target folder.   
![](resources/Pasted%20image%2020241212011057.png)   


16.) To test the jar is running or not run in the command line as below
```cmd
java -jar scalaMavenPro.jar
```

![](resources/Pasted%20image%2020241212014308.png)  