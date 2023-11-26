package $package;format="lower,package"$
package $name;format="lower,word"$
package core

import cats.*
import cats.effect.*

trait Computer[F[_]: Applicative]:
  def add(a: Int, b: Int): F[Int]

object Computer:
  def make[F[_]: Applicative]: Resource[F, Computer] = Resource.pure(
    new Computer[F]:
      override def add(a: Int, b: Int): F[Int] = F.pure(a + b)
  )

