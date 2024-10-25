package racingcar

class Controller(private val model: Model, private val view: View) {
    fun run() {
        val inputCarNames = view.getCars()
        val carNames = try {
            inputCarNames.split(',')
        } catch (_: Exception) {
            throw IllegalArgumentException("잘못된 자동차 입력입니다.")
        }
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.")
        }

        val inputTryNum = view.getTryNumber()
        val tryNum = try {
            inputTryNum.toInt()
        } catch (_: Exception) {
            throw IllegalArgumentException("잘못된 시도 횟수 입력입니다.")
        }
        if (tryNum <= 0) {
            throw IllegalArgumentException("시도 횟수가 0 이하 입니다.")
        }

        val cars = model.createCars(carNames)

        while (true) {
            model.moveAll(cars)
            val gameStatus = model.getStatus(cars)
            view.showStatus(cars)
            if (model.isDone(tryNum, gameStatus)) {
                view.showWinners(tryNum, cars)
                break
            }
        }
    }
}