package com.zuckonit.bufet.servers

import com.zuckonit.bufet.models.User
import com.zuckonit.bufet.stores.UserStore

class UserServer extends UserStore {
  override def getAll(): Array[User] = Array(User(1,"GET ALL"))
  override def getById(id: Int): User = User(id,"Get by ID")
}
