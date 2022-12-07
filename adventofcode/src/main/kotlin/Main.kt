import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    val inventoryFile = "/Users/tkatz/workspace-lms/adventofcode/day1/adventofcode/input.txt"
    parseSnacks(inventoryFile)


}

fun parseSnacks(fileName: String) {
    val elves = ArrayList<Elf>()

    var elf = Elf("Dominik", ArrayList())

    File(fileName).forEachLine {
        if (it == "") {
            elves.add(elf)
            elf = Elf("Michael", ArrayList())
        } else {
            val calories = Integer.valueOf(it)
            elf.snacks.add(calories)
            elf.totalAmount += calories
        }
    }
    elves.sortByDescending { it.totalAmount }
    println(elves)
}


data class Elf (
    val name: String,
    var snacks: MutableList<Int>,
    var totalAmount: Int = 0
)