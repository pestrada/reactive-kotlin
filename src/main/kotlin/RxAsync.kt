import io.reactivex.rxkotlin.toFlowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    var postFix = 0

    listOf("Alberto", "Peter", "Laura", "Carl", "James").toFlowable()
            .doOnNext { println("Item $it was reated on thread ${Thread.currentThread().name}") }
            .observeOn(Schedulers.newThread())
            .map { "$it-${postFix++}" }
            .doOnNext { println("Map operator was done on thread ${Thread.currentThread().name}") }
            .subscribeOn(Schedulers.newThread())
            .blockingSubscribe { println("Item $it was received on thread ${Thread.currentThread().name}") }
}