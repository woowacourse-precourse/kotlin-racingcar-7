package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarControllerTest: NsTest() {
    @Test
    fun `0 이하 시도 횟수 예외 처리`() {
        assertThrows<IllegalArgumentException> { run("pobi,ijh", "0") }
    }

    override fun runMain() {
        main()
    }
}