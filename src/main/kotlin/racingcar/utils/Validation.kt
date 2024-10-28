package racingcar.utils

import java.lang.NumberFormatException

class Validation {
    fun checkCarName(names:List<String>){
        checkCarNameLength(names)
        checkCarNameDuplication(names)
        checkCarMinimum(names)
    }

    fun checkCount(count:String){
        checkCountIsNum(count)
    }
    private fun checkCarNameLength(names:List<String>){
        for (name in names){
            if (name.length > 5 || name.isEmpty()){
                throw IllegalArgumentException(Constants().ERROR_NAME_LENGTH)
            }
        }
    }

    private fun checkCarNameDuplication(names:List<String>){
        val cars = mutableListOf<String>()
        for (name in names){
            if (cars.contains(name))
                throw IllegalArgumentException(Constants().ERROR_NAME_DUPLICATION)
            cars.add(name)
        }
    }

    private fun checkCarMinimum(names:List<String>){
        if (names.size < 2){
            throw IllegalArgumentException(Constants().ERROR_CAR_MINIMUM)
        }
    }

    private fun checkCountIsNum(count: String){
        try {
            count.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Constants().ERROR_COUNT_IS_NUM)
        }
    }
}