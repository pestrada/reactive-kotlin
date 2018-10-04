import io.reactivex.Flowable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toFlowable

fun main(args: Array<String>) {
    listOf("Alberto", "Peter", "Laura", "Carl", "James").toFlowable()
            .flatMap {
                if (it == "Carl")
                    Flowable.empty()
                else
                    Flowable.just(it)
            }
            .onErrorResumeNext(listOf("Name on db 1", "Name on db 2").toFlowable())
            .subscribeBy(
                    onNext = {
                        println(it)
                    },
                    onError = {
                        println("We had an exception")
                    },
                    onComplete = {
                        println("Stream is complete")
                    }
            )
}