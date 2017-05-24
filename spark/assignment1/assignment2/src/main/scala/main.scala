/**
  * Created by M1037790 on 5/24/2017.
  */


package com.mindtree.yorbit.sparkandscala

import java.util.Scanner

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Assignment2 {
  def main(args: Array[String]): Unit = {

    val scanner = new Scanner(System.in)

    println("1. How to sorts the elements in an array?")

    var unsortedArray = Array(5,65, 72, 81,86,78,4,9,0)
    println("Unsorted array :")
    print(unsortedArray.mkString(" "))
    println();
    println("Sorted array")
    println(unsortedArray.sorted.mkString(" "))

    println()

    println("2. Find the particular word count in the sentence.")
    //sample sentence
    val sentence  = "Apache Spark and Scala Advance Class : Class Spark"
    println("sentence :")
    println(sentence)
    val wordcount  = sentence.split(" ").foldLeft(Map.empty[String, Int]){
      (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
    }
    println("word count using only scala :")
    wordcount.foreach(println)

    println("3. Write the Scala program for finding the GREATEST COMMON DIVISOR (GCD) for two numbers using while loop?")
    println("enter two numbers to find GCD")
    var num1 = scanner.nextInt()
    var num2 = scanner.nextInt()
    while(num1!=num2)
    {
      if(num1 > num2)
        num1 -= num2;
      else
        num2 -= num1;
    }
    printf("GCD = %d\n",num1);
    println("4. Write the Scala function to get odd values and even values in a List?")
    println("actual list")
    println(list1)
    println("odd list: ")
    println(getOdd(list1))
    println("even list :")
    println(getEven(list1))
    println("5. Write the code for merging Array with ArrayBuffer?")

    var arr = Array[Int](1,2,3,4,6,7,8)
    var arrBuf = ArrayBuffer[Int](4,33,21,2)
    println("array :")
    println(arr.foreach(a =>print(a +" ")))
    println("array buffer :")
    println(arrBuf)
    var mergeBuf=this.MergeArrayWithBuffer(arr,arrBuf);

    println("merged result: ")
    println(mergeBuf)
  }

  var list1 = List(1,2,3,4,7,3,5,2,1,90,50,45,32,41)

  def getOdd (oList : List[Int]) :ArrayBuffer[Int]={
    var rList = ArrayBuffer[Int]();
    for(i<- 0 until oList.length){
      if (oList(i)%2 ==1) rList +=oList(i) ;

    }
    rList
  }
  def getEven (oList : List[Int]) :ArrayBuffer[Int]= {
    var rList = ArrayBuffer[Int]()
    for (i <- oList.indices) {
      if (oList(i) % 2 == 0) rList += oList(i)

    }
    rList
  }
  def MergeArrayWithBuffer(arr:Array[Int],arrBuf :ArrayBuffer[Int]):ArrayBuffer[Int]={
    for(i<- 0 until arr.length){
      arrBuf+=arr(i)
    }
    return arrBuf
  }

}

