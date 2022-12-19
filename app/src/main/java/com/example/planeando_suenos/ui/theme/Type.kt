package com.example.planeando_suenos.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R

val AvenirNext = FontFamily(
    Font(R.font.avenir_next_lt_heavy, FontWeight.W800),
    Font(R.font.avenir_next_lt_bold, FontWeight.W700),
    Font(R.font.avenir_next_lt_medium, FontWeight.W600),
    Font(R.font.avenir_next_lt_regular, FontWeight.W500),
    Font(R.font.avenir_next_lt_light, FontWeight.W400),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W700,
        fontSize = 26.sp
    ),
    h2 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    h3 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W600,
        fontSize = 22.sp
    ),
    h4 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    h5 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
    ),
    caption = TextStyle(
        fontFamily = AvenirNext,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)