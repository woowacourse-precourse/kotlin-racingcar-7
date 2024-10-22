package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(names: List<String>) {
    val cars: List<Car> = names.map { Car(it) }.toList()

    fun startOneRound() {
        for (car in cars) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (isGo(randomNumber)) {
                car.plusDrivingDistance()
            }
        }
    }

    private fun isGo(num: Int): Boolean {
        return num >= FORWARD_REFERENCE_NUMBER
    }

    companion object {
        const val FORWARD_REFERENCE_NUMBER = 4;
    }
}