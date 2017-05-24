/**
  * Created by M1037790 on 5/24/2017.
  */
import java.util

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._

import scala.collection.mutable

object main {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    val conf = new SparkConf().setAppName("assignmnent").setMaster("local")
    val sc = new SparkContext(conf)
    val sampledata = sc.textFile("./src/main/resources/sampledata.txt")
    println("1. Create RDDs to filter each line for the keyword “Spark”")
    println(" here sample data is loaded as RDD")
    val lineswithSpark =sampledata.filter(lines  =>  {lines.split(" ") contains "Spark"})
    println(" lines containing word spark : "+lineswithSpark.collect().length)

    println("2. Perform a WordCount of particular word in a sentence (pg1661.txt), i.e., so the results are (K, V) pairs of (word, count)")
    var sentence =" Get Spark from the downloads page of the project website. This documentation is for Spark version 2.1.0. Spark uses Hadoop’s client libraries for HDFS and YARN. Downloads are pre-packaged for a handful of popular Hadoop versions. Users can also download a “Hadoop free” binary and run Spark with any Hadoop version by augmenting Spark’s classpath. Scala and Java users can include Spark in their projects using its maven cooridnates and in the future Python users can also install Spark from PyPI.";
    val words = sc.parallelize(sentence.split(" "),2)
    val wordCount  = words.map(x => (x,1)).reduceByKey(_ + _)
    wordCount.foreach(println)

    println("joining two RDDS using join method")
    val x = sc.parallelize(List(("Hello", 1), ("World", 4),("Scala",3)))
    val y = sc.parallelize(List(("Hello", 2), ("Hello", 3),("World",2)))
    x.join(y).collect().foreach(println)
  }
}

