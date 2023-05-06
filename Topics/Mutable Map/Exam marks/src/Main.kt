fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    var name = readln()
    while (name != "stop" && name !in studentsMarks.keys) {
        studentsMarks[name] = readln().toInt()
        name = readln()
    }

    println(studentsMarks)
}