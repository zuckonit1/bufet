package com.zuckonit.bufet.stores

import java.util.Date

import com.zuckonit.bufet.enums.UserRole

case class User(
               id: Int,
               login: String,
               password: String,
               role : UserRole.Value,
               firstName: String,
               secondName : String,
               lastName: String,
               address:String,
               registrationTime : Date,
               //todo create object with all enviroment variables...
               avatat : String = "/images/avatars/default.jpg"
) extends Named {
  def name: String = login
}


trait UsersStore extends NamedStore[User]