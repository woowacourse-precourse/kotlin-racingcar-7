package racingcar.control

class Cars {
    fun cars(splitNames: List<String>): List<CarData> {
        val carList = splitNames.map { CarData(it) }
        val carPointGroupType = mutableListOf<Pair<String, Int>>()
        carList.forEach { car -> carPointGroupType.add(Pair(car.name, car.point)) }
        return carList
    }
}