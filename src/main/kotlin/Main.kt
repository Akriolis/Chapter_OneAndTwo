fun main(){
    val persons = listOf<Person>(
        Person("Alice"),
        Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")

    // statically typed

    // type interference - the ability of the compiler to determine types from cintext

    fun findAlice() = persons.filter {it.name == "Alice"}

    val name = persons[0].name;

    



}