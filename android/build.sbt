import android.Keys._
import android.Dependencies.{apklib,aar}

// load the android plugin into the build
android.Plugin.androidBuild

// project name, completely optional
name := "MikuMikuStudioAndroidApp"

// pick the version of scala you want to use
scalaVersion := "2.10.2"

// scala 2.10 flag for feature warnings
scalacOptions in Compile += "-feature"

javacOptions in compile ++= Seq("-source", "1.6",  "-target", "1.6")

// for non-ant-based projects, you'll need this for the specific build target:
platformTarget in Android := "android-17"

// call install and run without having to prefix with android:
run <<= run in Android

install <<= install in Android

resolvers += Resolver.file("testrepo3",file("/Users/kobayasi/NetBeansProjects/MMD/testrepo/ivy2/")) ( Patterns(false,"[organisation]/[module]/[revision]/[type]s/[artifact].[ext]") )

// libraryDependencies += aar("scalaandroidtestlib" % "scalaandroidtestlib" % "0.1-SNAPSHOT")
// libraryDependencies += "info.projectkyoto" % "mikumikustudio-lib-android" % "0.2-SNAPSHOT"

// test data(Amaha Sora, koshihuri dance)
libraryDependencies += "info.projectkyoto" % "mmstestdata" % "0.1-SNAPSHOT"

useProguard in Android := true

useSdkProguard in Android := false

proguardOptions in Android ++= Seq(
  "-ignorewarnings",
  "-keep class com.jme3.math.*",
  "-keepclassmembers class com.jme3.math.** {<methods>;}",
  "-keepclassmembers class com.jme3.bullet.** {<methods>;}",
  "-keepnames class com.jme3.** {*;}",
  "-keepclasseswithmembernames class com.google.ads.**",
  "-keep public class * extends com.jme3.app.Application",
  "-keep class scala.runtime.BoxedUnit"
)

// sourceDirectories <<= (sourceDirectories in (root,Compile))

libraryDependencies ++= Seq(
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "ch.qos.logback" % "logback-classic" % "1.0.13"
)