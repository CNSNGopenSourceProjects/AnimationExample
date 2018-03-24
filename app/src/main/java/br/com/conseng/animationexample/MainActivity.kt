package br.com.conseng.animationexample

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.security.InvalidParameterException

class MainActivity : AppCompatActivity() {

    private lateinit var txtAnimated: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtAnimated = lo_txt_view
    }

    fun doAnimation(view: View) {
        var animationType: Int
        var doGone = false

        when (view.id) {
            R.id.lo_btn_bounce -> animationType = R.anim.bounce
            R.id.lo_btn_fade_in -> animationType = R.anim.fade_in
            R.id.lo_btn_fade_out -> {
                animationType = R.anim.fade_out
                doGone = true
            }
            R.id.lo_btn_rotate -> animationType = R.anim.rotate
            R.id.lo_btn_slide_down -> animationType = R.anim.slide_down
            R.id.lo_btn_slide_up -> animationType = R.anim.slide_up
            R.id.lo_btn_zoom_in -> animationType = R.anim.zoom_in
            R.id.lo_btn_zoom_out -> animationType = R.anim.zoom_out
            else -> throw InvalidParameterException("ERROR: unknown button id=${view.id}")
        }

        if (View.GONE == txtAnimated.visibility)  txtAnimated.visibility = View.VISIBLE
        val animation = AnimationUtils.loadAnimation(this, animationType)
        txtAnimated.startAnimation(animation)
        if (doGone) Handler().postDelayed({ txtAnimated.visibility = View.GONE }, 1000)
    }
}
