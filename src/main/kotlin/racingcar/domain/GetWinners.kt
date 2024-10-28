package racingcar.domain

val List<Car>.winners: List<Car>
    get() {
        val maxDistance = maxOfOrNull { car -> car.distance } ?: return emptyList()
        return filter { car -> car.distance == maxDistance }
    }
