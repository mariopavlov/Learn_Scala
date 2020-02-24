package animals

object Run extends App {
    val myCat = new Cat(name = "Max", breed = "Persian")
    val myDog = new Dog(name = "Ron", breed = "Husky")

    println(
        s"${myCat.name} is ${myCat.breed}, and says ${myCat.speak}.\n",
        s"${myDog.name} is ${myDog.breed}, and says ${myDog.speak}"
    )
}
