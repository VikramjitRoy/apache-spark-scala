/**
  * Created by M1037790 on 5/24/2017.
  */




import org.apache.spark.{SparkConf, SparkContext}



object main {
  case class Employee (name :String, salary :Int)
  def main(args: Array[String]): Unit = {
    println("1. Write a spark code to count the words in a file.")
    val conf = new SparkConf().setAppName("assignmnent").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc);
    val log = sc.textFile("./src/main/resources/lorem.csv")
    val wordCount= log.flatMap(lines =>  lines.split(" ")).map(x => (x,1)).reduceByKey(_ + _).collect();

    for (count <- wordCount) {
      println(count)
    }


    val file= sc.textFile("./src/main/resources/employee.csv")
    val rowRDD = file.map(_.split(",")).map(p => Employee(p(0), p(1).toInt))
    val employeeDf = sqlContext.createDataFrame(rowRDD)
    employeeDf.registerTempTable("employee")
    println("2. Calculate Maxsalary")
    sqlContext.sql("SELECT MAX(salary) as MaxSalary from employee").show()
  }
}

