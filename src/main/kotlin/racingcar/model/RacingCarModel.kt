package racingcar.model

private const val ERROR_MESSAGE = "잘못된 입력입니다."

class RacingCarModel {
    private val exception = RacingCarException()

    fun checkException(stringNameOfCar: String) {
        if(exception.checkInvalidCharacter(stringNameOfCar) ||
            exception.checkHeadAndTail(stringNameOfCar)){
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
    }

    fun splitString(stringNameOfCar: String): Map<String, Int> {
        val splitString = stringNameOfCar.split(",")
        for (value in splitString) {
            if(exception.checkLength(value)){
                throw IllegalArgumentException(ERROR_MESSAGE)
            }
        }
        val infoOfCar = splitString.associateWith { 0 }
        return infoOfCar
    }
}