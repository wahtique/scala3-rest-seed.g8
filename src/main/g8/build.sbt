import Dependencies._

ThisBuild / organization := "$organization;format="lower,package"$"
ThisBuild / scalaVersion := "3.3.1"

lazy val commonSettings = {
  lazy val commonScalacOptions = Seq(
    Compile / console / scalacOptions := {
      (Compile / console / scalacOptions)
        .value
        .filterNot(_.contains("wartremover"))
        .filterNot(Scalac.Lint.toSet)
        .filterNot(Scalac.FatalWarnings.toSet) :+ "-Wconf:any:silent"
    },
    Test / console / scalacOptions :=
      (Compile / console / scalacOptions).value,
  )

  lazy val otherCommonSettings = Seq(
    update / evictionWarningOptions := EvictionWarningOptions.empty
    // cs launch scalac:3.3.1 -- -Wconf:help
    // src is not yet available for Scala3
    // scalacOptions += s"-Wconf:src=\${target.value}/.*:s",
  )

  Seq(
    commonScalacOptions,
    otherCommonSettings,
  ).reduceLeft(_ ++ _)
}

lazy val autoImportSettings = Seq(
  scalacOptions +=
    Seq(
      "java.lang",
      "scala",
      "scala.Predef",
      "scala.annotation",
      "scala.util.chaining",
    ).mkString(start = "-Yimports:", sep = ",", end = ""),
  Test / scalacOptions +=
    Seq(
      "org.scalacheck",
      "org.scalacheck.Prop",
    ).mkString(start = "-Yimports:", sep = ",", end = ""),
)

val commonDependencies = Seq(
  librayDependencies ++= Seq(
    org.typelevel.catsEffect
  ),
  libraryDependencies ++= Seq(
    org.scalameta.munit, // test framework
    org.scalacheck.scalacheck, // property testing
    org.scalameta.munitScalacheck, // scalacheck <-> munit
    org.typelevel.munitCatsEffect, // cats-effect <-> munit
    org.typelevel.scalacheckEffect // cats-effect <-> scalacheck
  ).map(_ % Test)
)

lazy val core =
  project
    .in(file("modules/core"))
    .settings(commonSettings)
    .settings(autoImportSettings)
    .settings(commonDependencies)

lazy val api =
  project
    .in(file("modules/api"))
    .settings(commonSettings)
    .settings(autoImportSettings)
    .settings(commonDependencies)
    .settings(
      libraryDependencies ++= Seq(
        com.softwaremill.sttp.tapir.tapirCore, // tapir api definition
        com.softwaremill.sttp.tapir.tapirJsonPickler // tapir experimental json module
      )
    )

lazy val server =
  project
    .in(file("modules/server"))
    .settings(commonSettings)
    .settings(autoImportSettings)
    .settings(commonDependencies)
    .settings(
      libraryDependencies ++= Seq(
        com.softwaremill.sttp.tapir.tapirHttp4sServer // tapir http4s backend
      )
    )

