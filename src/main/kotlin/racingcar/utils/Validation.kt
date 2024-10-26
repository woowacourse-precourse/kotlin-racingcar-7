package racingcar.utils

class Validation {
    fun carNameLength(names:List<String>){
        for (name in names){
            if (name.length > 5){
                throw IllegalArgumentException(Constants().ERROR_NAME_LENGTH)
            }
        }
    }
}