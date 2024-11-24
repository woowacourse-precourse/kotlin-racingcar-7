package racingcar.controller

import racingcar.model.Car
import racingcar.service.CarService
import racingcar.view.InputView
import racingcar.view.OutputView

class CarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val inputCarNames = inputView.getCars()
        val carNames = try {
            inputCarNames.split(',')
        } catch (_: Exception) {
            throw IllegalArgumentException(EXCEPTION_MSG_INVALID_CAR_NAME)
        }
        if (carNames.any { it.length > NAME_LENGTH_LIMIT }) {
            throw IllegalArgumentException(EXCEPTION_MSG_NAME_LENGTH_OVER)
        }

        val inputTryNum = inputView.getTryNumber()
        val tryNum = try {
            inputTryNum.toInt()
        } catch (_: Exception) {
            throw IllegalArgumentException(EXCEPTION_MSG_INVALID_TRY_NUM)
        }
        if (tryNum <= TRY_NUM_LOWER_LIMIT) {
            throw IllegalArgumentException(EXCEPTION_MSG_TRY_NUM_UNDER)
        }

        val cars = CarService.createCars(carNames)

        repeat(tryNum) {
            CarService.moveAll(cars)
            outputView.showStatus(cars)
        }
        outputView.showWinners(cars)
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