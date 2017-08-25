package com.zuckonit.bufet.models

import java.util.Date

import com.zuckonit.bufet.enums.{Position, Role}

trait Entity {}

case class ClientType(id : Int, name : String, discount : Int) extends Entity

trait UserEntity extends Entity

case class User(id: Int, firstName : String, secondName : String, lastName :String, avatar : String, address : String, role: Role.Value, login :String, password : String, regTime : Date) extends UserEntity
case class Employee(id : Int, user : User, position: Position.Value, upSalary : Boolean, downSalary : Boolean) extends UserEntity
case class Client(id: Int, user : User, `type`: ClientType) extends UserEntity

