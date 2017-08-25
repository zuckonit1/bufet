package com.zuckonit.bufet.stores

import com.zuckonit.bufet.enums.{EmployeePosition, EmployeeStatus}

case class Bufet(
                 id : Int,
                 title: String,
                 address: String,
                 phoneNumber: String,
                 tables : Option[Array[Desc]] = None,
                 employees: Option[Array[Employee]] = None,
                 //Product Count Units...
                 products : Option[Map[Array[Product],(Int,String)]] = None,
                 dishes : Option[Array[Dish]] = None,
                 orders : Option[Array[Order]] = None,
                ) extends Named {
  override def name: String = s"${title}"
}

trait BufetsStore extends NamedStore[Bufet] {
  def load( id : Int ): Bufet = load(id)
}
