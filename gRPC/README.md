# gRPC example

[What is RPC](https://searchapparchitecture.techtarget.com/definition/Remote-Procedure-Call-RPC)

[About gRPC](https://grpc.io/about/)

[gRPC official tutorials](https://grpc.io/docs/tutorials/)

(Example is in Java, implementation for other languages are similar, plz refer to the official tutorial for more examples)

In this example, a **Client** directory and a **Server** directory are provided. Both directory contain Java program maintained by **Maven** with identical file structure (Maven standard project structure)

./Client for example:

```shell
Client
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ieeeucsd
│   │   │       ├── App.java
│   │   │       └── Client.java
│   │   └── proto
│   │       └── rpc.proto
│   └── test
│       └── java
│           └── ieeeucsd
│               └── AppTest.java
...... 
```



In either directory, run the following to build, test, and package the jar:

```
mvn package
```



To execute using maven, run 

```
mvn exec:java
```



To execute via shell script, first we need to package the jar with jars of the dependencies inside maven repo, to package xxxxx-SNAPSHOT-jar-with-dependencies.jar, run

```shell
mvn clean compile assembly:single
```

then execute

```shel
./run.sh
```





