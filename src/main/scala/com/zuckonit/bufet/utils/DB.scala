package com.zuckonit.bufet.utils

import java.sql.{Connection, DriverManager}

import org.jooq.{DSLContext, SQLDialect}
import org.jooq.impl.DSL

trait DB {
  val url : String = "jdbc:postgresql://localhost:5432/db"
  val userName : String = "postgres"
  val password : String = "12345"

  lazy val connection : Connection = try{
    DriverManager.getConnection(url, userName, password)
  }
  catch {
    case e: Exception => e.printStackTrace(); null
  }
  lazy val context : DSLContext = DSL.using(connection,SQLDialect.POSTGRES_9_5)
}
