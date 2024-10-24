package racingcar

fun main() {
    val start = IOHandler().startMatch()
    val matchProgress = Racing()
    matchProgress.registaration = start
    val cars = matchProgress.racing()
    Rewarding(cars).awardWinner()
}
