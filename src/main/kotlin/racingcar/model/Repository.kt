package racingcar.model

class Repository {
    var userInput: String = ""
    var execCnt: Int = 0
    var racingCar: MutableList<String> = mutableListOf()
    var moveCnt: MutableList<Int> = mutableListOf()

    private fun initMoveCnt() {
        moveCnt = MutableList(racingCar.size) {0}
    }

    fun separateCarName() {
        racingCar = userInput.split(",").toMutableList()
        racingCar.removeAll(listOf(""))
        checkException()
        initMoveCnt()
    }

    private fun checkException() {
        var occurException: Boolean = false

        if (racingCar.isEmpty()) occurException = true
        racingCar.forEach{ str ->
            if (str.length > 6) occurException = true
        }

        if (occurException)
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }
}