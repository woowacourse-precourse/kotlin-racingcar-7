package racingcar.view

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

class InputTest :NsTest(){
    private lateinit var result: List<String>
    private var result2 by Delegates.notNull<Int>()

    @Test
    fun `자동차 이름을 입력 받아 리스트로 반환한다`() {
        run("Car1,Car2,Car3","3")
        assertEquals(listOf("Car1", "Car2", "Car3"), result)
    }
    @Test
    fun getCount() {
        run("Car1,Car2,Car3","3")
        assertEquals(3, result2)
    }

    override fun runMain() {
        result = Input().getCars()
        result2 = Input().getCount()
    }
}