package racingcar

class Organizer {
    private val input = Input()

    fun startRace() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val appliedCars: List<String> = input.inputCars()
        val isDuplicatedCar = appliedCars.distinct().count() != appliedCars.count()
        if (isDuplicatedCar) throw IllegalArgumentException("경주에 등록할 자동차 이름은 중복될 수 없습니다.")
        val raceCars: List<Car> = appliedCars.map { Car.validateCarName(it) }
    }
}