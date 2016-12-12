package test.readmoresample

import android.widget.TextView

fun TextView.isTextTruncated(): Boolean {
    val layout = this.layout ?: return false
    val lines = layout.lineCount
    if (lines < 1) return false
    val ellipsisCount = layout.getEllipsisCount(lines - 1)
    return ellipsisCount > 0
}
