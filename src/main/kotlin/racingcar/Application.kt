package racingcar

fun main() {
    val carNames = getCarNames()
    println("입력된 자동차 이름: $carNames")
}
fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: ""
    val names = input.split(",").map { it.trim() } // 이름을 쉼표로 구분하고, 양쪽 공백 제거
    return names
}
