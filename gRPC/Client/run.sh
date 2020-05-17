
# running mvn package would generate ****-SNAPSHOT.jar which
# doesn't include the dependency libraries in maven repo.
# To generate jar with dependencies, run mvn clean compile assembly:single

java -jar target/client-1.1-SNAPSHOT-jar-with-dependencies.jar