package com.zuckonit.bufet.services

import scala._
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

import com.zuckonit.bufet.servers.LanguageServer
import com.zuckonit.bufet.stores.{Language, LanguageStore}

@Path("/language")
//todo read about diffs between servers and services... maybe rename
class LanguageService extends LanguageStore {
  import LanguageServer.languageRecord2Language
  @GET
  @Path("/all")
  @Produces(Array(MediaType.APPLICATION_JSON))
  override def list: Array[Language] = LanguageServer.list

  override def find(req: String): Array[Language] = ???

  override def load(id: Int): Language = ???

  override def update(t: Language): Language = ???

  override def remove(id: Int): Unit = ???

  override protected def copy(entity: Language, name: String): Language = ???
}
