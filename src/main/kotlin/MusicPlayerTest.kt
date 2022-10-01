class MusicPlayerTest {
    private var songs: Array<String> = arrayOf()
    fun add (track:String){
        songs += track
    }

    fun show (){
        for (x in songs) println (x)
    }

    fun play(){
        println("Playing ${songs[0]}")
    }


    //your code goes here

}
fun main(args: Array<String>) {
    val m = MusicPlayerTest()

    while(true) {
        var input = readLine()!!
        if(input == "stop") {
            break
        }
        m.add(input)
    }
    m.show()
    m.play()
}