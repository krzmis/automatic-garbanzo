class Main {
    fun printHi(): String? {
        return "Hi"
    }
}

fun main(args: Array<String>) {
    val hi = Main()
    println(hi.printHi())
}