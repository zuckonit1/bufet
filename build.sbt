name := "bufet"

version := "0.1"

scalaVersion := "2.10.2"

enablePlugins(JettyPlugin)

libraryDependencies ++= Seq(
  "javax.ws.rs" % "javax.ws.rs-api" % "2.0",
  "org.jboss.resteasy" % "resteasy-jaxrs" % "3.1.0.CR3" exclude("org.slf4j", "slf4j-simple"),
  "com.fasterxml.jackson.jaxrs" % "jackson-jaxrs-json-provider" % "2.2.1",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.10" % "2.2.1",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.5"
)

libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "9.4.6.v20170531"

libraryDependencies += "org.jsoup" % "jsoup" % "1.10.3"

containerConfigFile := Some(file("etc/jetty.xml"))

webappPostProcess := {
  webappDir: File =>
    def listFiles(level: Int)(f: File): Unit = {
      val indent = ((1 until level) map { _ => "  " }).mkString
      if (f.isDirectory) {
        streams.value.log.info(indent + f.getName + "/")
        f.listFiles foreach { listFiles(level + 1) }
      } else streams.value.log.info(indent + f.getName)
    }
    listFiles(1)(webappDir)
}

libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"
libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4" % "jooq"
libraryDependencies += "org.flywaydb" % "flyway-core" % "3.2.1"

libraryDependencies ++= {
  val ver = "3.7.0"
  Seq(
    "org.jooq" % "jooq" % ver,
    "org.jooq" % "jooq-scala" % ver
  )
}

val jdbcDriver = "org.postgresql.Driver"
val jdbcUrl = "jdbc:postgresql://localhost:5432/db"
val jdbcUser = "postgres"
val jdbcPassword = "12345"
val jdbcSchema = "public"

Seq(flywaySettings: _*)

flywayOptions := Map(
  "driver" -> jdbcDriver,
  "url" -> jdbcUrl,
  "user" -> jdbcUser,
  "password" -> jdbcPassword,
  "schemas" -> Seq(jdbcSchema))


Seq(jooqSettings: _*)

jooqVersion := "3.7.0"

jooqOptions := Seq(
  "jdbc.driver" -> jdbcDriver,
  "jdbc.url" -> jdbcUrl,
  "jdbc.user" -> jdbcUser,
  "jdbc.password" -> jdbcPassword,
  "generator.database.name" -> "org.jooq.util.postgres.PostgresDatabase",
  "generator.database.inputSchema" -> jdbcSchema,
  "generator.target.packageName" -> "com.zuckonit.bufet.db")

jooqOutputDirectory <<= (sourceManaged in Compile)(_ / "jooq")
// for java naming conversion's
managedSourceDirectories in Compile <+= jooqOutputDirectory