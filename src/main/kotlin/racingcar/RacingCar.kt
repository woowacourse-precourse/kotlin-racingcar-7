package racingcar

class RacingCar(inputCarList: String) {

    private val _playCars: MutableMap<String, Int> = getCarMap(inputCarList)
    val playCars: Map<String, Int> get() = _playCars

    private fun getCarMap(carList: String): MutableMap<String, Int> {
        val carList = carList.split(",")
        val carMap = carList.associateWith { 0 }.toMutableMap()
        return carMap
    }

    fun updateCar(carName: String, num: Int) {
        _playCars[carName] = num
    }

}