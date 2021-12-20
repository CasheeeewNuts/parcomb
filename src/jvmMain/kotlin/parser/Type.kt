package parser

typealias Input = List<Char>

sealed interface ParseResult {
    data class Success<T>(val data: T, val rest: Input) : ParseResult
    object Fail : ParseResult
}