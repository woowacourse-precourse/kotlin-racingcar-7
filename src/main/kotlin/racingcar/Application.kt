package racingcar


fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: throw IllegalArgumentException("자동차 이름을 입력해야 합니다.")
    val carNames = input.split(",").map { it.trim() }

    carNames.forEach { name ->
        if (name.isEmpty()) {
            throw IllegalArgumentException("자동차 이름은 공백으로 둘 수 없습니다.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }

    if (carNames.size < 2) {
        throw IllegalArgumentException("자동차는 2대 이상이어야 합니다.")
    }

    carNames.forEach { name ->
        Racetrack.addCar(Car(name))
    }

    println("시도할 횟수는 몇 회인가요?")
    val attemptCount = readLine()?.toIntOrNull()?.takeIf { it > 0 }
        ?: throw IllegalArgumentException("유효한 숫자를 입력해야 하며, 1 이상의 숫자여야 합니다.")

    Racetrack.setMoveCount(attemptCount)
}


