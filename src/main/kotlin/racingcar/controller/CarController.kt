package racingcar.controller

import racingcar.Model
import racingcar.view.InputView

class CarController(private val model: Model, private val view: InputView) {
    fun run() {
        val inputCarNames = view.getCars()
        val carNames = try {
            inputCarNames.split(',')
        } catch (_: Exception) {
            throw IllegalArgumentException(EXCEPTION_MSG_INVALID_CAR_NAME)
        }
        if (carNames.any { it.length > NAME_LENGTH_LIMIT }) {
            throw IllegalArgumentException(EXCEPTION_MSG_NAME_LENGTH_OVER)
        }

        val inputTryNum = view.getTryNumber()
        val tryNum = try {
            inputTryNum.toInt()
        } catch (_: Exception) {
            throw IllegalArgumentException(EXCEPTION_MSG_INVALID_TRY_NUM)
        }
        if (tryNum <= TRY_NUM_LOWER_LIMIT) {
            throw IllegalArgumentException(EXCEPTION_MSG_TRY_NUM_UNDER)
        }

        val cars = model.createCars(carNames)

        repeat (tryNum) {
            model.moveAll(cars)
            view.showStatus(cars)
        }
        view.showWinners(cars)
    }

    companion object {
        const val NAME_LENGTH_LIMIT = 5
        const val TRY_NUM_LOWER_LIMIT = 0

        const val EXCEPTION_MSG_INVALID_CAR_NAME = "잘못된 자동차 입력입니다."
        const val EXCEPTION_MSG_NAME_LENGTH_OVER = "자동차 이름은 5글자 이하여야 합니다."
        const val EXCEPTION_MSG_INVALID_TRY_NUM = "잘못된 시도 횟수 입력입니다."
        const val EXCEPTION_MSG_TRY_NUM_UNDER = "시도 횟수가 0 이하 입니다."
    }
}