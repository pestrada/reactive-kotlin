import io.reactivex.Flowable
import io.reactivex.rxkotlin.blockingSubscribeBy
import io.reactivex.rxkotlin.toFlowable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    listOf("Alberto", "Peter", "Laura", "Carl", "James").toFlowable()
            .delay(10, TimeUnit.HOURS)
            .flatMap {
                if (it == "Carl")
                    Flowable.empty()
                else
                    Flowable.just(it)
            }
            .timeout(3, TimeUnit.SECONDS)
            //.onErrorResumeNext(listOf("Name on db 1", "Name on db 2").toFlowable())
            .blockingSubscribeBy(
                    onNext = {
                        println(it)
                    },
                    onError = {
                        println("We had an exception: $it")
                    },
                    onComplete = {
                        println("Stream is complete")
                    }
            )
}