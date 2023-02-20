package com.example.atosrm.presentation.ui.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.atosrm.R

val notoSans = FontFamily(
    Font(R.font.noto_sans_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.noto_sans_thin, FontWeight.Thin),
    Font(R.font.noto_sans_semi_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.noto_sans_semi_bold, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.noto_sans_regular),
    Font(R.font.noto_sans_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.noto_sans_medium, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.noto_sans_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.noto_sans_light, FontWeight.Light),
    Font(R.font.noto_sans_italic, style = FontStyle.Italic),
    Font(R.font.noto_sans_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.noto_sans_extra_light, FontWeight.ExtraLight),
    Font(R.font.noto_sans_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.noto_sans_extra_bold, FontWeight.ExtraBold),
    Font(R.font.noto_sans_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.noto_sans_bold, FontWeight.Bold),
)