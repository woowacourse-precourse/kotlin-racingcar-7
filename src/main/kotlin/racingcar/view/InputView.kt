package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val outputView = OutputView()

    fun getNameOfCars(): String? {
        outputView.enterNameOfCars()
        val nameOfCars = Console.readLine()
        return if (isNameOfCarsValid(nameOfCars)) {
            nameOfCars
        } else {
            throw IllegalArgumentException("Name of cars invalid")
        }
    }

    fun isNameOfCarsValid(nameOfCar: String?): Boolean {
        if (nameOfCar != null) {
            val regex = Regex(".+,.+")
            return regex.containsMatchIn(nameOfCar)
        }
        else
            return false
    }

    fun getTryCounts(): Int {
        outputView.enterTryCounts()
        return Console.readLine().toInt()
    }
}