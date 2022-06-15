const val MINUTE = 60
const val HOUR = 3_600
const val DAY = 86_400
const val TWO_DAYS = 172_800
const val THREE_DAYS = 259_200

fun main() {
    val secondOnline = 8000L
    println("был(а) в сети ${agoToText(secondOnline)}")
}

fun agoToText(secondOnline: Long) = when (secondOnline) {
    in 0 until MINUTE -> "только что"
    in MINUTE until HOUR -> "${timeToText(secondOnline)} назад"
    in HOUR until DAY -> "${timeToText(secondOnline)} назад"
    in DAY until TWO_DAYS -> "сегодня"
    in TWO_DAYS until THREE_DAYS -> "вчера"
    else -> "давно"
}

fun timeToText(secondOnline: Long) = when (secondOnline) {
    in MINUTE until HOUR -> {
        val min = secondOnline / MINUTE
        when (min % 10) {
            1L -> "$min минуту"
            in 2..4 -> "$min минуты"
            else -> "$min минут"
        }
    }
    else -> {
        val hour = secondOnline / HOUR
        when (hour % 10) {
            1L -> "$hour час"
            in 2..4 -> "$hour часа"
            else -> "$hour часов"
        }
    }
}