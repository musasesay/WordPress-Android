package org.wordpress.android.util

import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

class QuickStartUtils {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun stylizeQuickStartPrompt(string: String, color: Int, icon: Drawable? = null): Spannable {
            val startOfHighlight = string.indexOf("%1${'$'}s")

            var clearString = string.replace("%1${'$'}s", if (icon != null) " " else "")

            val endOfHighlight = clearString.indexOf("%2${'$'}s")
            clearString = clearString.replace("%2${'$'}s", "")

            val spannedString = SpannableStringBuilder(clearString)
            spannedString.setSpan(ForegroundColorSpan(color),
                    startOfHighlight, endOfHighlight, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            if (icon != null) {
                icon.setTint(color);
                spannedString.setSpan(ImageSpan(icon), startOfHighlight, startOfHighlight + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }

            return spannedString
        }
    }
}
