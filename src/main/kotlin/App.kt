import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith

fun main(args: Array<String>) {
    val db = FakeDb()

    db.getUsers()
            .flatMap { user ->
                db.getPointsForUser(user.key).zipWith(Observable.just(user.value)) { points, username ->
                    "$username has $points"
                }
            }
            .subscribe { println(it) }
}