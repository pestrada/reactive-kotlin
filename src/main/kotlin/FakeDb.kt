import io.reactivex.Observable
import kotlin.collections.Map.Entry

class FakeDb {
    fun getUsers(): Observable<Entry<Int, String>> {
        return Observable.fromIterable(mapOf(1 to "Peter", 2 to "Laura", 3 to "John", 4 to "Carl").entries)
    }

    fun getPointsForUser(userId: Int): Observable<Int> {
        val pointsMap = mapOf(1 to 40, 2 to 23, 3 to 0, 4 to 5)
        return Observable.just(pointsMap[userId])
    }
}