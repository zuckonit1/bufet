package com.zuckonit.bufet.stores

import javax.ws.rs.core.MediaType
import javax.ws.rs._

import com.zuckonit.bufet.models.User

@Path("/users")
trait UserStore extends Store{
  @GET
  @Path("all")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getAll() : Array[User]
  @GET
  @Path("user")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getById(@QueryParam("id") id : Int) : User

}
