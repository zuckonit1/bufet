package com.zuckonit.bufet.stores

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces, QueryParam}

trait Store[T] {
  @GET
  @Path("all")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getAll : Array[T]
  @GET
  @Path("user")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def get(@QueryParam("id") id : Int) : T
/*  def delete(id : Int)
  def add(entity : Entity)
  def update(entity: Entity)*/
}

