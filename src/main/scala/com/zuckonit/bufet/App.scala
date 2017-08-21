package com.zuckonit.bufet

import java.util
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

import com.zuckonit.bufet.servers.UserServer

@ApplicationPath("/")
class App extends Application  {
  override def getClasses: util.Set[Class[_]] = {
    val set = new util.HashSet[Class[_]]()
    set.add(classOf[UserServer])
    set
  }
}
