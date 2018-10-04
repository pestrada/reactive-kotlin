import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    GlobalScope.launch {
        println("Coroutine started")
        println("Coroutine finished")
    }
    println("Hello")
    Thread.sleep(2000)

    /*
    // takes more time and resources
    val job = List(1_000_000) {
        thread(start = true) {
            x++
        }
    }*/

    // coroutine is cheaper in resources, finishes faster
    var x = 0
    val job = List(1_000_000) {
        runBlocking {
            x++
        }
    }
}