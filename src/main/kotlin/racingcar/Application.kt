package racingcar

fun main() {
    val carNames = getCarNames()
    val moveCount = getMoveCount()
    println("입력된 자동차 이름: $carNames")
    println("입력된 이동 횟수: $moveCount")
}
fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: ""
    val names = input.split(",").map { it.trim() } // 이름을 쉼표로 구분하고, 양쪽 공백 제거
    return names
}

fun getMoveCount(): Int {
    println("시도할 횟수를 입력하세요.")
    val input = readLine() ?: "0"
    return input.toInt()
}
