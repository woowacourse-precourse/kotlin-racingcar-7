package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    CarRacingGame().startRace()
}

class CarRacingGame {
    private lateinit var cars: List<Car>
    private var attemptCount: Int = 0

    fun startRace() {
        cars = getCarNames()

        // attemptCount에 getAttemptCount()으로 시도 횟수 입력 받기

        println("실행 결과")
        // attemptCount만큼 반복하면서
        // 자동자 객체 별로 shouldMove와 moveForwardIfPossible 실행 -> printRaceStatus 출력
        repeat(attemptCount) {
            // raceRound()
            // printRaceStatus()
        }
        // printWinners()
    }

    private fun getCarNames(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = Console.readLine().split(",")
        require(names.all { it.length <= 5 && !it.contains(" ") }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능하며, 공백을 허용하지 않습니다.")
        }
        return names.map { Car(it) }
    }

    // getAttemptCount()

    // raceRound()

    // printRaceStatus()

    // printWinners()
}

class Car(val name: String) {
    var distance = 0
        private set

    fun moveForwardIfPossible() {
        if (shouldMove()) {
            distance++
        }
    }

    private fun shouldMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}