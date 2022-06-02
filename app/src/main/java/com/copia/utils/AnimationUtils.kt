package com.copia.utils

import android.app.Activity
import com.copia.R

fun Activity.animateSlideLeft() {
    overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
}

fun Activity.animateSlideRight() {
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}

fun Activity.animateFadeIn() {
    overridePendingTransition(R.anim.dialog_in_animation, 0)
}

fun Activity.animateFadeOut() {
    overridePendingTransition(0, R.anim.dialog_exit_animation)
}