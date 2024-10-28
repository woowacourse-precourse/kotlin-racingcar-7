package racingcar

class CheckInput {

    fun checkParticipant(cars: String): List<String> {
        val carList = cars.split(",")

        var finalParticipantCarList = mutableListOf<String>()
        for(car in carList) {
            checkInputCarNameSize(car)
            finalParticipantCarList.add(car.trim())
        }

        return finalParticipantCarList
    }

    fun checkInputCarNameSize(carName: String) {
        if(carName.length > 5) {
            throw IllegalArgumentException("잘못된 값입니다. (자동차 이름은 5자 이하로 구성)")
        } else if(carName.isBlank()) {
            throw IllegalArgumentException("잘못된 값입니다. (자동차 이름은 공백이 아닌 문자열 구성)")
        }
    }

    fun checkTrial(trialNum: String): Int {
        val checkedTrialNum = trialNum.toIntOrNull()
            ?: throw IllegalArgumentException("잘못된 값입니다. (시도 횟수는 숫자로 입력)")

        if(checkedTrialNum <= 0) {
            throw IllegalArgumentException("잘못된 값입니다. (시도 횟수는 양수로 입력)")
        }

        return checkedTrialNum
    }
}