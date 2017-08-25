package com.zuckonit.bufet.stores

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
                 orders : Option[Array[Order]] = None
                ) extends Named {
  override def name: String = title
}

trait BufetsStore extends NamedStore[Bufet]