package com.zuckonit.bufet.models

trait Entity {
  def id : Int
}
case class User(id: Int, name : String)
