package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// 전체 게임의 흐름 관리
class Game {
    // 게임 시작
    fun start() {
        val cars = inputCarNames()
        val roundCount = inputRoundCount()
        val race= Race(cars, roundCount)
        race.runStart()
    }
    // 자동차 이름 입력
    private fun inputCarNames(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = Console.readLine().split(",").map{it.trim()}
        inputNameException(carNames)
        return carNames.map {Car(it)}
    }
    // 시도할 횟수 입력
    private fun inputRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val roundCount = Console.readLine().toIntOrNull()
        Exceptions.validateRoundCount(roundCount)
        return roundCount!!
    }
    // 입력 받은 이름의 유효성 검사
    private fun inputNameException(carNames: List<String>) {
        Exceptions.nameLengthError(carNames)
        Exceptions.blankNameError(carNames)
        Exceptions.duplicateNameError(carNames)
    }
}

// 경주 진행 클래스
class Race(private val cars: List<Car>, private val roundCount: Int) {
    // 횟수만큼 경주 반복
    fun runStart() {
        repeat(roundCount) {
            raceOnce()
        }
        announceWinner()
    }
    // 한 라운드의 경주 진행
    private fun raceOnce() {
        for (car in cars) {
            car.move()
            println("${car.name} : ${car.move}")
        }
        println()
    }
    // 최종 우승자 발표
    private fun announceWinner() {
        val longest = findLongest()
        val winners = findWinners(longest)
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
    // 가장 멀리 이동한 거리 찾기
    private fun findLongest(): Int {
        return cars.maxByOrNull {it.getMoveDistance()}?.getMoveDistance() ?: 0
    }
    // 가장 멀리 간 우승자 리스트 찾기
    private fun findWinners(longest: Int): List<String> {
        return cars.filter {it.getMoveDistance()==longest}.map { it.name }
    }
}

// 각 자동차를 나타냄
data class Car(val name: String, var move: String = "") {
    // 자동차 움직이는 기능
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.move += "-"
        }
    }
    // 자동차가 이동한 거리를 반환
    fun getMoveDistance(): Int {
        return this.move.length
    }
}

// 유효성 검사 후 예외 처리
object Exceptions {
    // 자동차 이름 길이 검사
    fun nameLengthError(carNames: List<String>) {
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }
    // 이름 공백인지 검사
    fun blankNameError(carNames: List<String>) {
        if (carNames.any { it.isBlank() }) {
            throw IllegalArgumentException("자동차 이름은 공백일 수 없습니다.")
        }
    }
    // 중복된 이름 검사
    fun duplicateNameError(carNames: List<String>) {
        if (carNames.size != carNames.toSet().size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        }
    }
    // 시도할 횟수가 양의 정수인지 검사
    fun validateRoundCount(roundCount: Int?) {
        if (roundCount == null || roundCount < 1) {
            throw IllegalArgumentException("잘못된 입력입니다. 1 이상의 정수를 입력하세요.")
        }
    }
}

fun main() {
    Game().start()
}