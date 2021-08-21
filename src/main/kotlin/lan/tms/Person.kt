package lan.tms

interface Signatory {
    fun sign()
}

open class Person(val name: String, var age: Int, var isMarried: Boolean = false) : Signatory {
    var partnerName: String = ""

    override fun sign() = println("$name aged $age can sign documents (and their marital status is $isMarried)")

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Person("Lawrence", 23, true)
            s.sign()

            s.age = 54
            s.sign()

            s.partnerName = "Alice"
            println("Partner name is ${s.partnerName}")

            s.partnerName = "Bob"
            println("Partner name is ${s.partnerName}")
        }
    }
}

class Student(name: String, age: Int) : Person(name, age)

data class User(val name: String, val id: Int)

fun main(args: Array<String>) {
    val s = Person("Lawrence", 23, true)
    s.sign()

    s.age = 54
    s.sign()

    val kevin = User("Lawrence", 1)

    println(kevin)

    val (name, id) = kevin

    val lawrence = kevin.copy(id = 2)

    println(lawrence)

    println("User is $name and their id is $id")
    println("User is $name and their id is $id")
}