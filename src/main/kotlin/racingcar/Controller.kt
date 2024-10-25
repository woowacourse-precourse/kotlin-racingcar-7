package racingcar

class Controller(private val model: Model, private val view: View) {
    fun run() {
        val inputCarNames = view.getCars()
        val carNames = try {
            inputCarNames.split(',')
        } catch (_: Exception) {
            throw IllegalArgumentException("잘못된 자동차 입력입니다.")
        }

        val inputTryNum = view.getTryNumber()
        val tryNum = try {
            inputTryNum.toInt()
        } catch (_: Exception) {
            throw IllegalArgumentException("잘못된 시도 횟수 입력입니다.")
        }

        val cars = model.createCars(carNames)

        while (true) {
            model.moveAll(cars)
            model
        }
    }
}