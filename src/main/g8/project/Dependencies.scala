import sbt._

object Dependencies {
  object com {
    object softwaremill {
      object sttp {
        object tapir {
          val tapirCore = "com.softwaremill.sttp.tapir" %% "tapir-core" % "1.9.2"
          val tapirJsonPickler = "com.softwaremill.sttp.tapir" %% "tapir-json-pickler" % "1.9.2"
          val tapirHttp4sServer = "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % "1.9.2"
        }
      }
    }
  }

  object org {
    object scalacheck {
      val scalacheck = "org.scalacheck" %% "scalacheck" % "1.17.0"
    }

    object scalameta {
      val munit = moduleId("munit")
      val munitScalacheck = moduleId("munit-scalacheck")
      private def moduleId(artifact: String): ModuleID =
        "org.scalameta" %% artifact % "1.0.0-M10"
    }

    object typelevel {
      val catsEffect = "org.typelevel" %% "cats-effect" % "3.5.2"
      val munitCatsEffect ="org.typelevel" %% "munit-cats-effect" %  "2.0.0-M4"
      val scalacheckEffect = "org.typelevel" %% "scalacheck-effect" % "1.0.4"
    }
  }
}
