package racingcar.control

class Cars {
    fun cars(carNameSeperator: List<String>): List<CarData> {
        val carList = carNameSeperator.map { CarData(it) }
        val carPointGroupType = mutableListOf<Pair<String, Int>>()
        carList.forEach { car -> carPointGroupType.add(Pair(car.name, car.point)) }
        return carList
    }
}