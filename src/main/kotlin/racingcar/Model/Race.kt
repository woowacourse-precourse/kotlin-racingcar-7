package racingcar.Model

class Race(private val carsInGarage: List<Car>) {

    fun playOneRound(numberGenerator: RandomNumberGenerator): List<Car> {
        carsInGarage.forEach { car ->
            car.moveForward(numberGenerator.generateRandomNumber())
        }

        return carsInGarage
    }

}