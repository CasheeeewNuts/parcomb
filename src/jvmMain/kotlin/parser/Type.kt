package parser

typealias Input = List<Char>
typealias Parser<T> = (Input) -> ParseResult<T>

sealed interface ParseResult<T> {
    data class Success<T>(val isSucceed: Boolean = true, val data: T, val rest: Input) : ParseResult<T>
    data class Fail<T>(val isSucceed: Boolean = false) : ParseResult<T>
}