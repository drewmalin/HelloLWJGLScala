name := "HelloLWJGLScala"

version := "1.0"

scalaVersion := "2.12.1"

fork := true

val lwjglVersion = "3.1.1"
val osx = "macos"

libraryDependencies ++= Seq(

  "org.lwjgl" % "lwjgl" % lwjglVersion,
  "org.lwjgl" % "lwjgl" % lwjglVersion  % "runtime" classifier "natives-" + osx,

  "org.lwjgl" % "lwjgl-glfw" % lwjglVersion,
  "org.lwjgl" % "lwjgl-glfw" % lwjglVersion % "runtime" classifier "natives-" + osx,

  "org.lwjgl" % "lwjgl-opengl" % lwjglVersion
)

javaOptions ++= Seq(

  // Due to a current issue in OS X, the following is necessary
  "-XstartOnFirstThread"
)