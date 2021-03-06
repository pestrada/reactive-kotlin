import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith

fun main(args: Array<String>) {
    val db = FakeDb()
    db.getUserById(3)
            .subscribe { it -> println(it) }

    db.getAllUsers()
            .map { it.name }
            .subscribe { println(it) }

    db.getAllUsers()
            .flatMapSingle { db.getPointsForUserId(it.id) }
            .filter { it > 10 }
            .subscribe { println(it) }

    db.getAllUsers()
            .flatMapSingle {
                Single.just(it).zipWith(db.getPointsForUserId(it.id)) { user, points ->
                    "${user.name} has $points points!"
                }
            }
            .subscribe { println(it) }

    db.addUser(User(5, "Jessica"))
            .subscribe { println("User added successfully") }
}