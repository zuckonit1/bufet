package com.zuckonit.bufet.stores

import com.zuckonit.bufet.enums.{OrderType, Status}

case class Order(
                  id : Int,
                  employee: Employee,
                  time: Long,
                  status: Status.Value,
                  client : Client,
                  dishes : Option[Array[Dish]] = None,
                  orderType : OrderType.Value = OrderType.Offline,
                  desc : Option[Desc] = None,
                  places : Int = 0
                ) extends Named {
  override def name: String = id.toString
}

trait OrdersStore extends NamedStore[Order]
