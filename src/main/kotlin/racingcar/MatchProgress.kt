package racingcar

class MatchProgress {
    lateinit var registaration: Registaration

    fun matchProcess() {
        val cars = PreProcessing(registaration).preprocess()
        println("\n실행 결과")
    }
}

class PreProcessing(private var registaration: Registaration) {
    fun preprocess(): List<Result> {
        val validation = Validation()
        val cars = emptyList<Result>().toMutableList()

        validation.isDelimitersCorrect(registaration)
        splitCars().map {
            if (validation.isCarNameUnder5(it)) {
                cars.add(Result(carName = it))
            }
        }
        return cars
    }

    private fun splitCars(): List<String> {
        return registaration.cars.split(",")
    }

}

data class Result(
    val carName: String,
    var roundResult: List<Int> = listOf(),
    var score: Int = 0,
)