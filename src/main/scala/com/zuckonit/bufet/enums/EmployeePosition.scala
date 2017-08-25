package com.zuckonit.bufet.enums

object EmployeePosition extends Enumeration {
  protected class Position extends Value{
    private var sal : Int = 0
    override def id: Int = Value.id
    def this(s : Int) = {
      this()
      if (s > 0) sal = s
    }
    def salary = sal
    def salary(s : Int) = {if (s >= 0) sal = s}
  }
  protected object Position {
    def apply(): Position = new Position()
    def apply(salary : Int): Position = new Position(salary)
  }
  val Director,Cashier,Cook,Courier = Position()
}