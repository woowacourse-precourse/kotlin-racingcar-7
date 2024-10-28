package racingcar.control

class CarWithPoints {
    fun combineCarWithPoints(splitNames: List<String>): List<CarData> {
        val carList = splitNames.map { CarData(it) }
        val combineType = mutableListOf<Pair<String, Int>>()
        carList.forEach { car -> combineType.add(Pair(car.name, car.point)) }
        return carList
    }
}