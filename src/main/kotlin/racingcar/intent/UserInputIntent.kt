package racingcar.intent

sealed class UserInputIntent {
    data class EnterPlayerNameState(val userNames: String) : UserInputIntent()
    data class EnterPlayCountState(val playCount: String) : UserInputIntent()
}