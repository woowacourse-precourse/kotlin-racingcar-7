package racingcar.control

import racingcar.utils.SettingValue

class CarNameSplitter {
    fun splitNames(carName: String): List<String> {
        return carName.split(SettingValue.DELIMITER).filter { it.isNotBlank() }
    }
}