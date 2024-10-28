package racingcar.Model

class Race(carsInGarage: List<Car>) {
    private val racingCars: List<Car> = carsInGarage

    fun playOneRound(numberGenerator: RandomNumberGenerator): List<Car> {
        racingCars.forEach { car ->
            car.moveForward(numberGenerator.generateRandomNumber())
        }

        return racingCars
    }

    fun getWinner(): List<Car> {
        val maxPosition = racingCars.maxBy { it.position }.position

        return racingCars.filter { it.position == maxPosition }
    }

}