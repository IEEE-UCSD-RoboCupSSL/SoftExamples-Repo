# Maven



## install

1. ```shell
   sudo apt update
   ```

2. ```shell
   sudo apt install maven
   ```

3. verify installation:

   ```shell
   mvn -version
   ```



## Create new Java project

```shell
mvn archetype:generate -DgroupId=[company name] -DartifactId=[project name] -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

(make sure to define your own [company name] and [project name])

for example:

```shell
mvn archetype:generate -DgroupId=ieeeucsd -DartifactId=my_app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```



## POM

Maven uses pom.xml file to manage project dependencies.

After creating a java project, a default pom.xml is generated under project root directory

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>[company name]</groupId>
  <artifactId>[project name]</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>Server</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>

```

Recommend adding the following attribute to choose java version and add UTF-8 encoding

```xml
  <properties>
    <!-- specify java version -->
    <java.version>11</java.version>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>

    <!-- shut the encoding warning -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
```

pom.xml would be

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>[company name]</groupId>
  <artifactId>[project name]</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>Server</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
    
  <properties>
    <!-- specify java version -->
    <java.version>11</java.version>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>

    <!-- shut the encoding warning -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
    
</project>

```



## Compile

under root directory where pom.xml resides, run

```shell
mvn compile
```



## Clean

```shell
mvn clean
```



## Run tests

```shell
mvn test
```



## create .jar package

```shell
mvn package
```

which automatically compiles and run all tests



## Run main

* Method1:

  ```shell
  mvn exec:java -Dexec.mainClass="ieeeucsd.App"
  ```

  (here the package name is ieeeucsd, main class is "App")

* Method2: (after running mvn package)

  ```shell
  java --classpath target/[xxxx].jar [package].[main class name]
  ```

  the compiled .jar file is under ./target

  

## Add dependencies

Add google protobuffer as a example:

Find the pom script for the dependency online, and copy the script to the pom.xml file

https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java/3.11.4

Example pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>ieeeucsd</groupId>
  <artifactId>client</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>client</name>
  <url>http://maven.apache.org</url>


  <dependencies>
    <!-- Junit -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

    <!-- protoc 3.11.4 -->
    <!-- https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java -->
    <dependency>
        <groupId>com.google.protobuf</groupId>
        <artifactId>protobuf-java</artifactId>
        <version>3.11.4</version>
    </dependency>


  </dependencies>

  
  <properties>
    <!-- specify java version -->
    <java.version>11</java.version>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>

    <!-- shut the encoding warning -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

</project>
```



## Download dependencies

https://stackoverflow.com/questions/10533828/what-does-mvn-install-in-maven-exactly-do

```shell
mvn install
```

another often used command:

```
mvn clean install
```



## Build/Rebuild Image

```shell
mvn clean install
```

this command usually needs to be executed every time you find your dependencies are missing, this may happen when java tests don't pass, causing a packaging failure



## Example on gPRC dependency adding (Java)

referenced links:

* https://github.com/grpc/grpc-java/blob/master/README.md
* https://www.xolstice.org/protobuf-maven-plugin/usage.html

pom.xml: 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>ieeeucsd</groupId>
  <artifactId>client</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>client</name>
  <url>http://maven.apache.org</url>


  <dependencies>
    <!-- Junit -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

    <!-- protoc 3.11.4 -->
    <!-- https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java -->
    <dependency>
        <groupId>com.google.protobuf</groupId>
        <artifactId>protobuf-java</artifactId>
        <version>3.11.4</version>
    </dependency>

    <!-- grpc -->
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-netty-shaded</artifactId>
        <version>1.29.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-protobuf</artifactId>
        <version>1.29.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-stub</artifactId>
        <version>1.29.0</version>
    </dependency>
    <dependency> <!-- necessary for Java 9+ -->
        <groupId>org.apache.tomcat</groupId>
        <artifactId>annotations-api</artifactId>
        <version>6.0.53</version>
        <scope>provided</scope>
    </dependency>

  </dependencies>

  
  <properties>
    <!-- specify java version -->
    <java.version>11</java.version>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>

    <!-- shut the encoding warning -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <!-- protoc gen and grpc gen -->
  <build>
    <extensions>
      <extension>
        <groupId>kr.motd.maven</groupId>
        <artifactId>os-maven-plugin</artifactId>
        <version>1.6.2</version>
      </extension>
    </extensions>
    <plugins>
      <plugin>
        <groupId>org.xolstice.maven.plugins</groupId>
        <artifactId>protobuf-maven-plugin</artifactId>
        <version>0.6.1</version>
        <configuration>
          <protocArtifact>com.google.protobuf:protoc:3.11.4:exe:${os.detected.classifier}</protocArtifact>
          <pluginId>grpc-java</pluginId>
          <pluginArtifact>io.grpc:protoc-gen-grpc-java:1.29.0:exe:${os.detected.classifier}</pluginArtifact>
        </configuration>
        <executions>
          <execution>
            <goals>
              <goal>compile</goal>
              <goal>compile-custom</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

</project>
```

Then run

```shell
mvn clean install
```

this will generate proto and gRPC java source files under "target/generated-sources/protobuf/....."

(VSCode might warn certain error of the generated files or the pom files, simply ignore them, they might disappear after VSCode complete parsing syntax for quite a while, not sure why vscode does this)



