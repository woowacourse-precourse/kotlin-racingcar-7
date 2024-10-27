package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

const val RANDOM_START_NUM = 0
const val RANDOM_END_NUM = 9
const val RANDOM_TARGET_NUM = 4

const val UNIT_DISTANCE: Long = 1

const val RACE_RESULT_HEADER_MESSAGE = "실행 결과"
const val RACE_RESULT_FINAL_WINNER_MESSAGE_PREFIX = "최종 우승자 : "

class Race(private val carNameList: Iterable<String>, private val rounds: Long) {
    private val carList: List<Car> = carNameList.map { Car(it) }

    fun run() {
        print("\n")
        println(RACE_RESULT_HEADER_MESSAGE)
        for (i in 0..rounds) {
            executeRound()
            printRoundResult()
        }
        print(RACE_RESULT_FINAL_WINNER_MESSAGE_PREFIX)
        print(calculateFinalWinners().joinToString(", ") { it.name })
    }

    private fun executeRound() {
        for (car in carList) {
            tryToMoveCarForward(car, UNIT_DISTANCE)
        }
    }

    private fun tryToMoveCarForward(car: Car, distance: Long): Boolean {
        if (pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM) >= RANDOM_TARGET_NUM) {
            car.moveForward(distance)
            return true
        }
        return false
    }

    private fun printRoundResult() {
        for (car in carList) {
            print(car.name)
            print(" : ")
            print(convertDistanceToDash(car.distance))
            print("\n")
        }
        print("\n")
    }

    private fun convertDistanceToDash(distance: Long): String {
        val chars = mutableListOf<Char>()
        for (i in 0..<distance) {
            chars.add('-')
        }
        return chars.joinToString("")
    }

    private fun calculateFinalWinners(): Iterable<Car> {
        var maxDistance = 0L
        var winners = mutableListOf<Car>()
        for (car in carList) {
            if (car.distance == maxDistance) {
                winners.add(car)
                maxDistance = car.distance
            } else if (car.distance > maxDistance) {
                winners = mutableListOf()
                winners.add(car)
                maxDistance = car.distance
            }
        }
        return winners
    }

}