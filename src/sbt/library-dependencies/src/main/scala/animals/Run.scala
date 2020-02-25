package animals

import net.liftweb.util.Helpers._
import net.liftweb.json._

object Run extends App {
    implicit val formats = DefaultFormats

    val myCat = new Cat(name = "Max", breed = "Persian")
    val myDog = new Dog(name = "Ron", breed = "Husky")

    println(s"${myCat.name} is ${myCat.breed}, and says ${capify(myCat.speak)}.")
    println(s"${myDog.name} is ${myDog.breed}, and says ${capify(myDog.speak)}.")

    println(s"Here is the ${myCat.name} as a JSON object.")
    println(prettyRender(Extraction.decompose(myCat)))
}
