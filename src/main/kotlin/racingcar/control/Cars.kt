import racingcar.control.CarData

class Cars {
    fun cars(carNameSeperator: List<String>): List<CarData> {
        val carPointGroup = carNameSeperator.map { CarData(it) }
        val carPointGroupType = mutableListOf<Pair<String, Int>>()
        carPointGroup.forEach { car -> carPointGroupType.add(Pair(car.name, car.point)) }
        return carPointGroup
    }
}