import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

abstract class NsTestCopy {
    private lateinit var standardOut: PrintStream
    private lateinit var captor: OutputStream

    @BeforeEach
    protected fun init() {
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    @AfterEach
    protected fun printOutput() {
        System.setOut(standardOut)
        println(output())
    }

    protected fun output(): String = captor.toString().trim { it <= ' ' }

    protected fun run(vararg args: String) {
        try {
            command(*args)
            runFunction()
        } finally {
            Console.close()
        }
    }

    protected fun runException(vararg args: String) {
        try {
            run(*args)
        } catch (ignore: NoSuchElementException) {
        }
    }

    private fun command(vararg args: String) {
        val buf =
            java.lang.String
                .join("\n", *args)
                .toByteArray()
        System.setIn(ByteArrayInputStream(buf))
    }

    protected abstract fun runFunction()
}
