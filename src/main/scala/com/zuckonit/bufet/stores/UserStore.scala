package com.zuckonit.bufet.stores

import java.util.Date
import javax.ws.rs.core.MediaType
import javax.ws.rs._

import com.zuckonit.bufet.enums.Role
import com.zuckonit.bufet.models.{User, UserEntity}

@Path("/store/users")
trait UserStore extends Store[UserEntity] {

}
