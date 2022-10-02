class Pet {
    private var name: String = ""

    private var age: Int = 0

    var setAge = age
        set(value) {
           field = value
        }

    val getAge: Int
        get() {
            return age
        }

    fun setAge2(age: Int){
        this.age = age
    }

    constructor(name: String){
        this.name = name
    }


}