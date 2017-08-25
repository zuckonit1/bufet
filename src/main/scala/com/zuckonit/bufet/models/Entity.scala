package com.zuckonit.bufet.models

import java.util.Date

import com.zuckonit.bufet.enums.{EmployeePosition,ClientType,UserRole}

trait Entity {}
trait UserEntity extends Entity

case class User(id: Int, firstName : String, secondName : String, lastName :String, avatar : String, address : String, role: UserRole.Value, login :String, password : String, regTime : Date) extends UserEntity
case class Employee(id : Int, user : User, position: EmployeePosition.Value, upSalary : Boolean, downSalary : Boolean) extends UserEntity
case class Client(id: Int, user : User, `type`: ClientType.Value) extends UserEntity