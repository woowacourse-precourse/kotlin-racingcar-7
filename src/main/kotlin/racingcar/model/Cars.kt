package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Cars(val carNames: List<String>) {
    val list: List<Car> = carNames.map { Car(it) }

    fun move() {
        for (car in list) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) car.moveForward()
        }
    }
}
