package com.example.tasker.utils

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

object AnimUtilskt {

    fun slideView(view: View, currentHeight: Int, newHeight: Int) {
        val slideAnimator = ValueAnimator
            .ofInt(currentHeight, newHeight)
            .setDuration(300)

        /* We use an update listener which listens to each tick
         * and manually updates the height of the view  */
        slideAnimator.addUpdateListener { valueAnimator: ValueAnimator ->
            val value: Int = valueAnimator.animatedValue as Int
            view.layoutParams.height = value
            view.requestLayout()
        }

        /*  We use an animationSet to play the animation  */
        val animationSet = AnimatorSet()
        animationSet.interpolator = AccelerateDecelerateInterpolator()
        animationSet.play(slideAnimator)
        animationSet.start()
    }

    fun rotateFab(
        fab: FloatingActionButton,
        rotateTo: Float,
        buttonColor: Int,
        imageColor: Int) {

        fab.backgroundTintList = ColorStateList.valueOf(buttonColor)
        fab.imageTintList = ColorStateList.valueOf(imageColor)

        ViewCompat.animate(fab)
            .rotation(rotateTo)
            .withLayer()
            .setDuration(200L)
            .setInterpolator(LinearInterpolator())
            .start()
    }
}