import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object main {
  case class ActorDetail(id: Int,actorname:String ,genre:String,noofmovies:Int,hits:Int)
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    val conf = new SparkConf().setAppName("assignmnent").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    println("1. Please construct the dataset as given below using Seq and case class ActorDetail.")
    val seqOfActorDetail = getData()
    println("2. Construct a data frame using the above dataset by creating 2 partitions (use parallelize method).")
    val actDetails = sc.parallelize( seqOfActorDetail,2)
    println(" data frame is constructed")
    val actorDetailDF =sqlContext.createDataFrame(actDetails)
    println("3. Show the all the details of the actDetailsDF and also show only the first two records of the actorDetails dataset.")
    actorDetailDF.collect().foreach(println)
    println("4. How do you print the schema of the actor details dataframe?")
    actorDetailDF.printSchema()
    println("5. Register the DataFrame as temp table and only select the rows for whom the no of hits are more than 250 and print the output.")
    import org.apache.spark.sql.functions._
    var x = actorDetailDF.filter(col("hits")>250).collect().foreach(println)


  }
  def getData() : Seq[ActorDetail] = {
    val data = "1001,Johnny Lever,Commedian,210,190\n" +
      "1002,Amit Mahesh,New Comer,2,1\n" +
      "1003,Salman Khan,SuperStar,300,291\n" +
      "1004,Johnny Depp,SuperStar,289,270\n" +
      "1005,Mallika Sherawat,Actress,20,10\n" +
      "1006,Amitabh Bachan,SuperStar,350,300\n" +
      "1007,Micheal Bijlu,New Comer,4,1\n" +
      "1008,Rocky Angelo,New Comer,3,1\n" +
      "1009,Rajani Kanth,SuperStar,400,399\n" +
      "1010,Arnold,SuperStar,261,242"
    data.split("\n").map(line => {
      val cols: Array[String] = line.split(",")
      ActorDetail(cols(0).toInt, cols(1), cols(2), cols(3).toInt, cols(4).toInt)
    })
  }
}
