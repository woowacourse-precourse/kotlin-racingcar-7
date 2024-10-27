package racingcar.view

enum class InputViewString(private val transmission: String){
    CAR_NAME_GUIDE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    RACING_TRY_GUIDE("시도할 횟수는 몇 회인가요?");
    override fun toString() = transmission
}

enum class ExceptionString(private val transmission: String){
    BLANK("빈 문자열은 조건에 맞지 않습니다."),
    LENGTH("이름이 5글자를 초과하였습니다."),
    NOT_NAME("이름 형식에 맞지 않습니다");
    override fun toString() = transmission
}

enum class ExceptionInt(private val transmission: String){
    NOT_UINT("정상적인 양의 정수를 받지 못했습니다.");
    override fun toString() = transmission
}