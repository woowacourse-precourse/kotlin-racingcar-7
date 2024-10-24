package racingcar.model

class Repository {
    var userInput: String = ""
    var execCnt: Int = 0
    var raceCar: MutableList<String> = mutableListOf()

    fun separateCarName() {
        raceCar = userInput.split(",").toMutableList()
        raceCar.removeAll(listOf(""))
        checkException()
    }

    private fun checkException() {
        var occurException: Boolean = false

        if (raceCar.isEmpty()) occurException = true
        raceCar.forEach{ str ->
            if (str.length > 6) occurException = true
        }

        if (occurException)
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }
}