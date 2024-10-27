package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

const val RANDOM_START_NUM = 0
const val RANDOM_END_NUM = 9
const val RANDOM_TARGET_NUM = 4

const val UNIT_DISTANCE: Long = 1

class Race(private val carNameList: Iterable<String>, private val rounds: Long) {
    private val carList: List<Car> = carNameList.map { Car(it) }

    fun run() {

    }

    private fun executeRound() {
        for (car in carList) {
            tryToMoveCarForward(car, UNIT_DISTANCE)
        }
    }

    private fun tryToMoveCarForward(car: Car, distance: Long): Boolean {
        if (pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM) <= RANDOM_TARGET_NUM) {
            car.moveForward(distance)
            return true
        }
        return false
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