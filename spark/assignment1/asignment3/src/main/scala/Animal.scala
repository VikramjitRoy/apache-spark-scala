/**
  * Created by M1037790 on 5/24/2017.
  */
class Dog {
  def bark(): Unit ={
    println("bow bow")
  }
}
trait Cat {
  def growl(): Unit = {
    println("meeow ")
  }
}

class Animal extends Dog with Cat{

}

