package racingcar.constans

object PlayCountError {
    val errorMessageForEmptyPlayCount by lazy {
        "빈 이동 횟수가 입력 되었어요."
    }
    val errorMessageForInValidPlayCount by lazy {
        "이동 횟수는 정수만 입력해주세요"
    }
    val errorMessageForInValidPlayCountByZero by lazy {
        "이동 횟수가 0이면 게임을 진행할 수 없어요 1이상 입력해주세요"
    }
    val errorMessageForExceededMaxPlayCount by lazy {
        "이동 횟수는 1천회 이하로 입력해주세요"
    }
}