package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    CarRacingGame().startRace()
}

class CarRacingGame {
    private lateinit var cars: List<Car>
    private var attemptCount: Int = 0

    fun startRace() {
        // cars에 getCarNames()으로 자동차 이름 입력 받기

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

    // getCarNames()

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