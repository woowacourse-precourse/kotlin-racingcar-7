package racingcar

fun main() {
    // TODO: 프로그램 구현
    val validator = Validator()
    val cars = Cars(validator)
    val race = Race(cars)
    race.start()
}