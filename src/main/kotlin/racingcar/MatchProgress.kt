package racingcar

class MatchProgress(val registaration: Registaration) {
    fun matchProcess() {
        preprocess()
        println("\n실행 결과")
    }

    fun preprocess(): List<String> {
        val validation = Validation()

        validation.isDelimitersCorrect(registaration)
        val cars = registaration.cars.split(",")
        validation.isCarNameUnder5(cars)
        return cars
    }
}
