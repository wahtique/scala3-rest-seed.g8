package $package;format="lower,package"$
package $name;format="lower,word"$
package core

import cats.effect.*
import core.Computer
import munit.CatsEffectSuite
import munit.ScalaCheckEffectSuite
import org.scalacheck.effect.PropF

final class ComputerSuite extends CatsEffectSuite with ScalaCheckEffectSuite:

  val computerFixture = ResourceSuiteLocalFixture(
    "computer",
    Computer.make[IO]
  )

  override def munitFixtures = List(computerFixture)

  test("add two integers"):
    PropF.forAllF: (a: Int, b: String) =>
      computerFixture.use: computer =>
        assertIO(computer.add(a, b), a + b)