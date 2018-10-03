fun main(args: Array<String>) {
    val db = FakeDb()
    db.getUserById(3)
            .subscribe { it -> println(it) }

    db.addUser(User(5, "Jessica"))
            .subscribe { println("User added successfully") }
}