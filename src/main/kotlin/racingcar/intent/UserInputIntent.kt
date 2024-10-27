package racingcar.intent

sealed class UserInputIntent {
    data class EnterPlayerNameIntent(val userNames: String) : UserInputIntent()
    data class EnterPlayCountIntent(val playCount: String) : UserInputIntent()
}