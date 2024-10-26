package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.constans.Constants.MESSAGE_GUIDE_FOR_INPUT_COUNT
import racingcar.constans.Constants.MESSAGE_GUIDE_FOR_USER_NAME
import racingcar.intent.UserInputIntent.EnterPlayCountState
import racingcar.intent.UserInputIntent.EnterPlayerNameState

class RacingView{

    init {
        startGame()
    }

    private fun startGame(){
        inputPlayerNames()
    }

    private fun inputPlayerNames() {
        val userNames = getUserInput(MESSAGE_GUIDE_FOR_USER_NAME)
        val intent = EnterPlayerNameState(userNames)
    }

    private fun getUserInput(msg: String): String{
        println(msg)
        return readLine().trim()
    }
}