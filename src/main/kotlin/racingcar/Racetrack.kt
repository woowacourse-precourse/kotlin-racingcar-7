package racingcar

object Racetrack {
    private val cars: MutableList<Car> = mutableListOf() // 경기 중인 자동차
    private var attemptCount: Int = 0 // 경기 이동 횟수

    // 자동차 추가
    fun addCar(car: Car) {
        cars.add(car)
    }

    // 경기 이동 횟수 설정
    fun setAttemptCount(count: Int) {
        attemptCount = count
    }
}