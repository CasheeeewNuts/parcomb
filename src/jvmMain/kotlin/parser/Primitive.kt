package parser

import lib.head
import lib.tail

fun anyChar(input: Input): ParseResult {
    if (input.isEmpty()) {
        return ParseResult.Fail()
    }

    return ParseResult.Success(
        true,
        input.head,
        input.tail
    )
}

fun eof(input: Input): ParseResult {
    if (input.isNotEmpty()) {
        return ParseResult.Fail()
    }

    return ParseResult.Success(true, null, input)
}