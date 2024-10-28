package racingcar

class RacingCar(val name: String) {
    private val racingCars = name.split(",")
    val racingCarsWithNumber = mutableMapOf<String, Int>()

    init {
        validateName()
        initializeRacingCarsWithNumber()
    }

    fun initializeRacingCarsWithNumber() {
        for (racingCar in racingCars) {
            racingCarsWithNumber[racingCar] = 0
        }
    }

    fun checkLength() {
        for (racingCar in racingCars) {
            if (racingCar.length > 5) {
                throw IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.")
            }
        }
    }

    fun checkNumber() {
        if (racingCars.size < 2) {
            throw IllegalArgumentException("[ERROR] 경기 진행을 위해서는 최소 2대의 자동차를 입력해야 합니다.")
        }
    }

    private fun validateName() {
        checkLength()
        checkNumber()
    }
}