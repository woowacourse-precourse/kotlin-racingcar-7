package racingcar

import org.junit.jupiter.api.Assertions.*
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `이름이 유효할 때 limitNameLength가 이름을 반환해야 한다`() {
        val validName = "pobi"
        assertEquals(validName, limitNameLength(validName))
    }

    @Test
    fun `이름이 5자를 초과하면 limitNameLength가 예외를 던져야 한다`() {
        val invalidName = "pobixx"
        val exception = assertThrows<IllegalArgumentException> {
            limitNameLength(invalidName)
        }
        assertEquals("이름은 5자 이하여야 합니다.", exception.message)
    }

    @Test
    fun `이름이 공백일 때 isNameCheck가 예외를 던져야 한다`() {
        val invalidName = "  " // 공백만 있는 이름
        val exception = assertThrows<IllegalArgumentException> {
            isNameCheck(invalidName)
        }
        assertEquals("이름은 공백이 아니어야 합니다.", exception.message)
    }

    @Test
    fun `중복된 이름이 있을 때 isDuplicateNames가 예외를 던져야 한다`() {
        val duplicateNames = listOf("pobi", "crong", "pobi")
        val exception = assertThrows<IllegalArgumentException> {
            isDuplicateNames(duplicateNames)
        }
        assertEquals("중복된 이름이 존재합니다.", exception.message)
    }

    @Test
    fun `이름 리스트를 정상적으로 분할해야 한다`() {
        val names = "pobi,woni"
        val expected = listOf("pobi", "woni")
        assertEquals(expected, divideNames(names))
    }

    @Test
    fun `currentPosition이 현재 위치를 출력해야 한다`() {
        val names = listOf("pobi", "woni")
        val position = mapOf("pobi" to 2, "woni" to 1)

        currentPosition(names, position)
    }

    @Test
    fun `race 함수가 올바른 위치를 반환해야 한다`() {
        val names = "pobi,woni"
        val tryNumber = 3
        val participants = divideNames(names)

        val result = race(participants, tryNumber)

        assertEquals(2, result.size)
        assertTrue(result.keys.containsAll(listOf("pobi", "woni")))
    }


    @Test
    fun `winner 함수가 최종 우승자를 출력해야 한다`() {
        val names = "pobi,woni,jun"
        val tryNumber = 5
        val participants = divideNames(names)

        val position = race(participants, tryNumber)
        val winners = findWinners(position)

        assertTrue(winners.isNotEmpty())
    }


    override fun runMain() {
        main()
    }
}
