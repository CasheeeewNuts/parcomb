package parser

import lib.head
import lib.tail
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestPrimitive {
    @Nested
    inner class TestAnyChar {
        @Test
        @DisplayName("Empty input")
        fun testEmptyInput() {
            val input = listOf<Char>()
            val output = anyChar(input)

            assertEquals(output, ParseResult.Fail)
        }

        @Test
        @DisplayName("1 character input")
        fun testWith1Character() {
            val input = listOf('a')
            val output = anyChar(input)

            assertEquals(output, ParseResult.Success(
                input.head,
                input.tail
            ))
        }

        @Test
        @DisplayName("Many characters input")
        fun testWithManyCharacters() {
            val input = "many characters".toList()
            val output = anyChar(input)

            assertEquals(output, ParseResult.Success(
                input.head,
                input.tail
            ))
        }
    }

    @Nested
    inner class TestEOF {
        @Test
        fun testWithEmptyInput() {
            val input = listOf<Char>()
            val output = eof(input)

            assertEquals(output, ParseResult.Success(null, input))
        }

        @Test
        fun testWith1Character() {
            val input = listOf('a')
            val output = eof(input)

            assertEquals(output, ParseResult.Fail)
        }
    }
}