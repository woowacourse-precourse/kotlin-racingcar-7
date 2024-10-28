package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.Model.Exception

class InputView {
    private val outputView = OutputView()
    private val exception = Exception

    fun getNameOfCars(): Any? {
        outputView.enterNameOfCars()
        val nameOfCars = Console.readLine()
        return if (isNameOfCarsValid(nameOfCars)) {
            nameOfCars
        } else {
            exception.errorComesUpWith(INVAID_CAR_NAMES_INPUT)
        }
    }

    fun isNameOfCarsValid(nameOfCar: String?): Boolean {
        if (nameOfCar != null) {
            val regex = Regex(".+,.+")
            return regex.containsMatchIn(nameOfCar)
        } else
            return false
    }

    fun getTryCounts(): Any {
        outputView.enterTryCounts()
        val tryCounts = Console.readLine().toIntOrNull() ?: 0
        return if (isTryCountsValid(tryCounts)) {
            tryCounts
        } else {
            exception.errorComesUpWith(INVAID_TRY_COUNTS_INPUT)
        }
    }

    private fun isTryCountsValid(tryCounts: Int): Boolean {
        return tryCounts > 0
    }

    companion object {
        private const val INVAID_CAR_NAMES_INPUT = "두 대 이상의 자동차들을 쉼표(,)를 기준으로 구분하여 입력해주세요."
        private const val INVAID_TRY_COUNTS_INPUT = "양의 정수인 시도 횟수를 입력해주세요."
    }
}