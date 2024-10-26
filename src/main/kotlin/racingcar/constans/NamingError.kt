package racingcar.constans

object NamingError {
    val errorMessageForEmptyInput by lazy {
        "입력이 비어있어요 이름을 입력해 주세요"
    }
    val errorMessageForEmptyName by lazy {
        "빈 이름이 입력 되었어요 이름을 입력해 주세요"
    }
    val errorMessageForInvalidPlayerCount by lazy {
        "혼자선 게임을 플레이 하실 수 없어요 플레이어는 2명 이상 입력해주세요"
    }
    val errorMessageForInvalidSeparator by lazy {
        "구분자는 쉼표(,)로 입력해주세요"
    }
    val errorMessageForInvalidNameFormat by lazy {
        "자동차 이름은 한글, 영어, 숫자만 가능하며 1~5자여야 합니다."
    }
    val errorMessageForDuplicatedName by lazy {
        "이름은 중복 될 수 없어요"
    }
}