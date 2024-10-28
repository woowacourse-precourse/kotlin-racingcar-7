package racingcar

fun main() {
    // TODO: 프로그램 구현

    val carNames = Input.getCarNames()
    val attempts = Input.getNumberOfAttempts()

}

// # 입력 기능 추가
object Input {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = readLine().orEmpty()
        val carNames = input.split(",").map { it.trim() }
        require(carNames.all { it.length <= 5 }) { "자동차 이름은 5자 이하만 가능합니다." }
        return carNames
    }

    fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("정수 값만 입력 가능합니다.")
        require(input > 0) { "시도 횟수는 1회 이상이어야 합니다." }
        return input
    }
}

