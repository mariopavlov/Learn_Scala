package animals

case class Dog(name: String, breed: String) extends Animal {
    def speak = "woof woof"
}
