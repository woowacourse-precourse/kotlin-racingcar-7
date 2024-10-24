package racingcar

import racingcar.model.Car

fun isValidName(name: String) : Boolean {
    if (name.length > 5) {
        throw IllegalArgumentException()
    }
    return true
}

fun isValidRound(round: Int): Boolean {
    if (round > 0) {
        return true
    }
    throw IllegalArgumentException()
}

fun splitName(names: String): List<String> {
    return names.split(",")
}

fun createCar(names: List<String>) : Map<String, Car> {
    val cars = mutableMapOf<String, Car>()
    for (name in names) {
        if (isValidName(name)) {
            cars[name] = Car(0, 0)
        }

    }
    return cars
}

fun main() {
    repeat(inputRound) {
        for (car in cars) {
            val currentlocation: Int = car.value.location
            val line = "-"
            println("${car.key} : ${line.repeat(currentlocation)}")

        }
        println()
    }

    var top = 0
    var winner = ""

    for (car in cars) {
        if (car.value.location > 0) {
            top = car.value.location
        }
    }

    for (car in cars) {
        if (car.value.location == top) {
            if (winner == "") {
                winner = car.key
            } else {
                winner += ", ${car.key}"
            }
        }
    }
}
