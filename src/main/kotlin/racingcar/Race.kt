package racingcar

class Race(private val tryCount: Int, private val cars: List<Car>) {
    init {
        checkValidate()
    }

    private fun checkValidate() {
        require(tryCount >= 0) { WRONG_TRY_COUNT_MESSAGE }
    }

    fun run() = (0 until tryCount).map {
        moveCar()
        cars
    }

    private fun moveCar() {
        cars.forEach { car ->
            car.move()
        }
    }

    companion object {
        private const val WRONG_TRY_COUNT_MESSAGE = "시도 횟수는 0이상이어야 합니다."
    }
}