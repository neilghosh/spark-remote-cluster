# Steps

## Install & Run Spark

1. brew install apache-spark
2. Run master : /usr/local/Cellar/apache-spark/2.3.1/bin/spark-class org.apache.spark.deploy.master.Master
3. Run Slave(s) : /usr/local/Cellar/apache-spark/2.3.1/bin/spark-class org.apache.spark.deploy.worker.Worker    spark://<MASTER_IP>:7077 -c 1 -m 512M
4. Run an example on master : /usr/local/Cellar/apache-spark/2.3.1/bin/run-example SparkPi

## Generate Jar
mvn package -Dmaven.test.skip=true

## Run the program 
mvn test

## Submit using script  
/usr/local/Cellar/apache-spark/2.3.1/bin/spark-submit --class WordCountTask  -v  --master local[2]  target/first-example-1.0-SNAPSHOT.jar src/test/resources/loremipsum.txt src/test/resources/

## TODO
Submit the jar programatically using SparkLauncher
mvn exec:java -Dexec.mainClass="WcSparkLauncher" 

