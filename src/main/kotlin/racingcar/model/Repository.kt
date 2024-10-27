package racingcar.model

class Repository {
    var userInput: String = ""
    var execCnt: Int = 0
    var racingCars: MutableList<RacingCar> = mutableListOf()
    var winner: MutableList<String> = mutableListOf()

    fun separateCarName() {
        racingCars = userInput.split(",")
            .map { RacingCar(it) }
            .toMutableList()
        racingCars.removeIf { it.carName.isEmpty()}
        checkException()
    }

    private fun checkException() {
        var occurException = false

        if (racingCars.isEmpty()) occurException = true
        racingCars.forEach{ car ->
            if (car.carName.length >= 6) occurException = true
        }

        if (occurException)
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }

    fun increaseMoveCnt(idx: Int) {
        racingCars[idx].moveCnt += 1
    }

    fun selectWinner() {
        val maxMoveCnt: Int = racingCars.maxOf { it.moveCnt }

        winner = racingCars.filter { it.moveCnt == maxMoveCnt }
            .map { it.carName }
            .toMutableList()
    }
}