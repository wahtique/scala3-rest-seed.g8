package $package;format="lower,package"$
package $name;format="lower,word"$
package api

import sttp.tapir.*
import sttp.tapir.json.pickler.*

final case class AddRequest(a: Int, b: Int) derives Pickler
final case class AddResponse(result: Int) derives Pickler

object MathEndpoints:
  val add = endpoint
    .post
    .in(path[Int]("a"))
    .in("plus")
    .in(path[Int]("b"))
    .mapTo[AddRequest]
    .out(jsonBody[AddResponse])