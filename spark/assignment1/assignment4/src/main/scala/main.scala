/**
  * Created by M1037790 on 5/24/2017.
  */

import org.apache.spark.{SparkConf, SparkContext}

object main {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Movie Analysis").setMaster("local")
    val sc = new SparkContext(conf)
    val log = sc.textFile("./src/main/resources/errorLog.log")
    val errors = log.flatMap(lines =>  lines.split(" "))
      .filter(e => {
        println(e+" ")
        e=="org.alfresco.error.AlfrescoRuntimeException:" }).collect().length;
    println("4. Write the spark program to count the error messages in log file")
    println("no of errors in log file is  :")
    println(errors)


  }
}