package animals

case class Cat(name: String, breed: String) extends Animal {
    def speak = "meow"
}
