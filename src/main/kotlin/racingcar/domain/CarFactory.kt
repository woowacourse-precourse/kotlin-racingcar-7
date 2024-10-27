package racingcar.domain

class CarFactory {

    companion object {

        private fun carGenerator(carNames: List<String>, randomNumber: RandomNumber): List<Car> =
            carNames.map { carName -> Car(carName, randomNumber) }

    }

}
