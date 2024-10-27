package racingcar

fun main() {
    val input = Input()
    val (carNames, count) = input.carNamesAndCount()
    val racingCars = carNames.map { RacingCar(it) }
    val sb = StringBuilder("\n실행 결과\n")
    for (i in 0 until count) {
        racingCars.forEach(RacingCar::move)
        racingCars.forEach(sb::appendLine)
        sb.appendLine()
    }
    val maxCount = racingCars.maxOf { it.moveCount }
    sb.appendLine("최종 우승자 : ${racingCars.filter { it.moveCount == maxCount }.joinToString(", ") { it.carName }}")
    println(sb)
}
