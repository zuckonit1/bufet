package com.zuckonit.bufet.servers



import java.util.Date

import com.zuckonit.bufet.enums.UserRole
import com.zuckonit.bufet.models.{Entity, User, UserEntity}
import com.zuckonit.bufet.stores.{Store, UserStore}

class UserServer extends UserStore{
  override def getAll: Array[UserEntity] = Array[UserEntity](User(1,"Alexander","Sergeevich", "Nesterenko","","", UserRole.Admin,"zuckonit1","zuckonit1",new Date()))
  override def get(id: Int): UserEntity = User(id,"Alexander","Sergeevich", "Nesterenko","","", UserRole.Admin,"zuckonit1","zuckonit1",new Date())
}
