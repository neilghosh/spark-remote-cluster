This example programatically starts a spark job to a cluster setup locally in Mac. Similarly the program could be used to refer a remote master node (original code referred to local master) to submit a job.

Spark master/slaves/jobs could be monitored at http://localhost:8080/

# Steps

## Install & Run Spark

1. brew install apache-spark
2. Run master : /usr/local/Cellar/apache-spark/2.3.1/bin/spark-class org.apache.spark.deploy.master.Master
3. Run Slave(s) : /usr/local/Cellar/apache-spark/2.3.1/bin/spark-class org.apache.spark.deploy.worker.Worker    spark://<MASTER_IP>:7077 -c 1 -m 512M
4. Master UI can be accessed through http://localhost:8080/
5. Run an example on master : /usr/local/Cellar/apache-spark/2.3.1/bin/run-example SparkPi

## Generate Jar
mvn package -Dmaven.test.skip=true

## Run the program 
mvn test

## Submit using script  
/usr/local/Cellar/apache-spark/2.3.1/bin/spark-submit --class WordCountTask  -v  --master local[2]  target/first-example-1.0-SNAPSHOT.jar src/test/resources/loremipsum.txt src/test/resources/

## TODO
Submit the jar programatically using SparkLauncher
mvn exec:java -Dexec.mainClass="WcSparkLauncher" (Has issues currently)

Code reference :- https://github.com/melphi/spark-examples/tree/master/first-example

