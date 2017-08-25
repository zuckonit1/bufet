package com.zuckonit.bufet.stores

import com.zuckonit.bufet.enums.{EmployeePosition, EmployeeStatus}

case class Employee(
                   id : Int,
                   user: User,
                   position : EmployeePosition.Value,
                   status : EmployeeStatus.Value,
                   bufet : Bufet
                 ) extends Named {
  override def name: String = s"${user.firstName} ${user.secondName} ${user.lastName}"
}

trait EmployeesStore extends NamedStore[Employee] {
  def load( id : Int ): Employee = load(id)
}


