package esra.avsar.gamedatabaseapp.ext

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun String.parseDate(
    currentFormat: String = "yyyy-MM-dd",
    targetFormat: String = "dd MMMM yyyy"
): String? {
    return try {
        val current = SimpleDateFormat(currentFormat)
        val target = SimpleDateFormat(targetFormat)
        current.parse(this)?.let {
            target.format(it)
        }
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}
