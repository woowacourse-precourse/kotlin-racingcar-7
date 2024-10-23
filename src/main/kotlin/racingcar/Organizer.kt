package racingcar

class Organizer {
    private val input = Input()
    private val rules = Rules()

    fun startRace() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val appliedCars: List<String> = input.inputCars()
        val isDuplicatedCar = appliedCars.distinct().count() != appliedCars.count()
        if (isDuplicatedCar) throw IllegalArgumentException("경주에 등록할 자동차 이름은 중복될 수 없습니다.")
        val raceCars: List<Car> = appliedCars.map { Car.validateCarName(it) }
        println("시도할 횟수는 몇 회인가요?")
        val raceCount = input.inputRaceCount()
        if (!rules.isValidRaceCount(raceCount)) {
            throw IllegalArgumentException("경주 횟수는 최소 1회 이상이며, 정수형만 입력 가능합니다.")
        }
    }
}