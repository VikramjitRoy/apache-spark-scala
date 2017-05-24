/**
  * Created by M1037790 on 5/24/2017.
  */

import java.util.Scanner

object main {
  def main(args: Array[String]): Unit = {
    println("1. Create a Map - Add the new key and value to the existing Map")
    var map = scala.collection.mutable.Map("1" -> "One", "2" -> "Two")
    println(map)
    map.put("3", "Three")
    println(map)
    println()

    val scanner = new Scanner(System.in);
    println("Remove existing key from the Map (black)")
    map.remove("1")
    println(map)
    println()

    println("2. Create an Employee class with method increment and currentSalary and use a read-only property salary.")
    var employee = new Employee();
    println("Salary(read only)")
    println(employee.currentSal());
    println(" increment of 3000")
    println(employee.increment(3000));
    println()

    println("3. Write a Scala program to add all the elements in the Array by using reduceLeft function.")
    println("original array :")
    var arr = Array(56, 13, 46, 2, 61);
    arr.foreach(x =>print(x+" "))
    var result =arr.reduceLeft(add);
    print("result: ")
    println(result)
    println()

    println("4. Please do a sample implementation of Multiple Inheritance in Scala.")
    println("Animal with cat trait and dog class")
    var animal = new Animal();
    animal.bark()
    animal.growl()
    println("-------------------------------------------------")
  }
  def add(res: Int, x: Int):Int = {
    //println(s"op: $res + $x = ${res + x}")

    // scala considers last statement to be the result
    res + x;
  }
}
