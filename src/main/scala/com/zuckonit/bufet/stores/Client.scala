package com.zuckonit.bufet.stores

import com.zuckonit.bufet.enums.ClientType

case class Client(
                 id : Int,
                 user: User,
                 clientType : ClientType.Value
) extends Named{
  override def name: String = s"${user.firstName} ${user.secondName} ${user.lastName}"
}

trait ClientsStore extends NamedStore[Client]
