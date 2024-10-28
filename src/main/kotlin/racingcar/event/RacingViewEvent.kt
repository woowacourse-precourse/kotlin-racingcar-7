package racingcar.event

sealed class RacingViewEvent {
    data class InputPlayerName(val userNames: String) : RacingViewEvent()
    data class InputPlayCount(val playCount: String) : RacingViewEvent()
}