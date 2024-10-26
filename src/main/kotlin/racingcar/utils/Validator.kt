package racingcar.utils

object Validator {
    fun validateCarName(carList: List<String>) {
        carList.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("이름은 5자 이내여야합니다.")
            } else if(it.isBlank()) {
                throw IllegalArgumentException("이름에 공백이 포함되어 있습니다.")
            }
        }
    }

    fun validateMoveCount(moveCount: Int){
        if(moveCount <= 0){
            throw IllegalArgumentException("시도 횟수는 0이 아닌 양의 정수여야합니다.")
        }
    }
}