/**
  * Created by M1037790 on 5/24/2017.
  */

class Employee {

  private var salary =10000;
  def increment(incr :Int):Int={
    salary = salary + incr;
    return salary;
  }
  def currentSal():Int = {
    return  salary;
  }

}

