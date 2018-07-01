import java.io.IOException;

import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

/**
 * Hello world!
 *
 */
public class WcSparkLauncher {
  public static void main(String[] args) {

    try {
      System.out.println("Submitting the jar");
      Process handle = new SparkLauncher()
          .setAppResource("target/first-example-1.0-SNAPSHOT.jar")
          .setMainClass("WordCountTask")
          .setMaster("spark://192.168.1.199:7077")
          .setDeployMode("cluster")
          .setSparkHome("/usr/local/Cellar/apache-spark/2.3.1/")
          .addSparkArg("--verbose")
          .launch();

      handle.waitFor();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
