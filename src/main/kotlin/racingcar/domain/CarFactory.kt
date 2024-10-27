package racingcar.domain

class CarFactory {

    companion object {

        fun createCars(carNames: List<String>, randomNumber: RandomNumber): List<Car> {
            validateCarNamesCount(carNames)
            validateUniqueCarNames(carNames)
            return carGenerator(carNames, randomNumber)
        }

        private fun carGenerator(carNames: List<String>, randomNumber: RandomNumber): List<Car> =
            carNames.map { carName -> Car(carName, randomNumber) }

        private fun validateCarNamesCount(carNames: List<String>) =
            require(carNames.size > 1) { "차가 2대 이상있어야 레이싱을 시작할 수 있습니다." }

        private fun validateUniqueCarNames(carNames: List<String>) =
            require(carNames.size == carNames.toSet().size) { "차 이름은 중복입력할 수 없습니다." }

    }

}
