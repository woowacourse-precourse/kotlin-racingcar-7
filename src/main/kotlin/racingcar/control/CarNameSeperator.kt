package racingcar.control

class CarNameSeperator {
    fun carNameSeperator(carName: String): List<String> {
        return carName.split(SettingValue().DELIMITER).filter { it.isNotBlank() }
    }
}