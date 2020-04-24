package com.fhit.test.microspark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * @author wty
 * @create 2020-04-29 15:53
 */
public class SimpleApp {
    public static void main(String[] args) {
        System.out.println("spark start ...");
//        String logFile = "file:///C:/tools/spark/myinput/spark-text.txt"; // Should be some file on your system
        String logFile = args[0]; // Should be some file on your system
        SparkConf conf = new SparkConf().setAppName("Simple Application");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> logData = sc.textFile(logFile).cache();

        //统计包含a的行数
        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) {
                return s.contains("a");
            }
        }).count();

        //统计包含b的行数
        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) {
                return s.contains("b");
            }
        }).count();

        System.out.println("---------------------Lines with a: " + numAs + ", lines with b: " + numBs);

        sc.stop();
    }
}
