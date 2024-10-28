package racingcar

class CarDisplay {
    fun display(car: Car): String {
        return "${car.name} : ${GO.repeat(car.distance)}"
    }

    companion object {
        const val GO = "-"
    }
}