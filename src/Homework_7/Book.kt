package Homework_7

class Book(var title: String, var author: String, var year: Int, val id: Int): LibraryItem(id), Borrowable {


    override fun toString(): String {
        return "Book \"$title\", author $author, year $year"
    }

    override fun borrow(user: String) {
        println("$user позаимствовал книгу \"$title\"")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (author != other.author) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        return result
    }

}