package racingcar.view

import camp.nextstep.edu.missionutils.Console.close
import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.constans.Constants.MESSAGE_GUIDE_FOR_INPUT_COUNT
import racingcar.constans.Constants.MESSAGE_GUIDE_FOR_USER_NAME
import racingcar.di.DependencyInjector
import racingcar.intent.UserInputIntent.EnterPlayCountState
import racingcar.intent.UserInputIntent.EnterPlayerNameState
import racingcar.model.CarRacingState.PlayResultState
import racingcar.viewModel.RacingViewModel

class RacingView(private val viewModel: RacingViewModel) {

    init {
        startGame()
        val result = viewModel.onCompleteValidationCheck()
        closeGame(result)
    }

    private fun startGame() {
        inputPlayerNames()
        inputPlayCount()
    }

    private fun inputPlayerNames() {
        val userNames = getUserInput(MESSAGE_GUIDE_FOR_USER_NAME)
        val intent = EnterPlayerNameState(userNames)
        viewModel.onCompleteInput(intent)
    }

    private fun inputPlayCount() {
        val playCount = getUserInput(MESSAGE_GUIDE_FOR_INPUT_COUNT)
        val intent = EnterPlayCountState(playCount)
        viewModel.onCompleteInput(intent)
    }

    private fun getUserInput(msg: String): String {
        println(msg)
        return readLine().trim()
    }

    private fun closeGame(state: PlayResultState) {
        state.printWinner()
        close()
    }
}