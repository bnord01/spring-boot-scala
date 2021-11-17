/*
  General Scala attributes
 */
scalaVersion := "2.13.7"

/*
  General project attributes
 */
organization := "de.codecentric"
name := "SpringBootScala"
version := "0.1"
maintainer := "Björn Jacobs <bjoern.jacobs@codecentric.de>"
description := "A demo how to use Spring Boot with Scala for building a basic microservice"
organizationHomepage := Some(url("http://www.codecentric.de"))

/*
  Project dependencies
 */
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "2.5.6",
  "org.springframework.boot" % "spring-boot-configuration-processor" % "2.5.6"
)

/*
  Packaging plugin
 */

// enable the Java app packaging archetype and Ash script (for Alpine Linux, doesn't have Bash)
enablePlugins(JavaAppPackaging, AshScriptPlugin)

// set the main entrypoint to the application that is used in startup scripts
Compile / mainClass := Some("de.codecentric.microservice.MyServiceApplication")

// the Docker image to base on (alpine is smaller than the debian based one (120 vs 650 MB)
dockerBaseImage := "openjdk:8-jre-alpine"

// creates tag 'latest' as well when publishing
dockerUpdateLatest := true
