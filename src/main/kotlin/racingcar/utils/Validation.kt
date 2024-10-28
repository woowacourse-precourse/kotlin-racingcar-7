package racingcar.utils

class Validation {
    fun checkCarName(names:List<String>){
        checkCarNameLength(names)
        checkCarNameDuplication(names)
    }
    private fun checkCarNameLength(names:List<String>){
        for (name in names){
            if (name.length > 5){
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
}