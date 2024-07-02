scalaVersion := "2.13.14"

name := "trip"

libraryDependencies += "org.reactivemongo" %% "reactivemongo" % "1.0.10"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "2.0.12"

libraryDependencies += "com.bot4s" %% "telegram-core" % "5.8.2"

libraryDependencies += "com.bot4s" %% "telegram-akka" % "5.8.2"

enablePlugins(JavaAppPackaging)
