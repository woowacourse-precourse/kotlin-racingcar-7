package racingcar.domain

fun List<Car>.tryMove(): Unit = forEach(Car::tryMove)
