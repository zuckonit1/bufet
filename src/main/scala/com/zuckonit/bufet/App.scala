package com.zuckonit.bufet

import java.util
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

import com.zuckonit.bufet.services.LanguageService

class App extends Application {
  override def getClasses: util.Set[Class[_]] = {
    val set = new java.util.HashSet[Class[_]]
    set.add(classOf[LanguageService])
    set
  }
}
