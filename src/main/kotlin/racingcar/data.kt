package racingcar

data class Registaration(
    val cars: String,
    val round: Int,
)

data class Result(
    val carName: String,
    var roundResult: MutableList<Int> = mutableListOf(),
    var score: Int = 0,
)