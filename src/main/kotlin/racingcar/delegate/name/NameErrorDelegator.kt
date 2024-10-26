package racingcar.delegate.name

interface NameErrorDelegator {
    // 이름이 비어있는 경우
    fun checkInputIsEmpty(userInput: String)
    // 모둔 구분자가 잘못된 경우
    fun checkForInvalidSeparator(userNames: List<String>)
    // 이름이 영어/한글/숫자만 포함되지 않은 경우
    fun checkForInvalidNameFormat(userNames: List<String>)
    // 이름이 중간에 비어있는 경우
    fun checkForEmptyName(userNames: List<String>)
    // 플레이어가 2명 미만인 경우
    fun checkForInvalidPlayerCount(userNames: List<String>)
    // 이름이 중복되는 경우
    fun checkForDuplicateName(userNames: Map<String, Int>)
}