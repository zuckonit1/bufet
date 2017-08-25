package com.zuckonit.bufet.utils

import com.zuckonit.bufet.enums.{ClientType, EmployeePosition, EmployeeStatus}

object Parser extends App{
  println(EmployeePosition.Director.salary)
  EmployeePosition.Cashier.salary(1000)
  EmployeePosition.Director.salary(100)
  println(EmployeePosition.Director.salary)
  println(EmployeePosition.Cashier.salary)
}
