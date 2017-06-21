package zihe.org.www.kotlindemo

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by BurNIng on 2017/6/12 09：42.
 * Copyright @DC
 */
class InformationDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            linearLayout {
                backgroundColor = Color.parseColor("#4fc3f7")
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER
                imageView {
                    image = ContextCompat.getDrawable(ctx,R.mipmap.ic_launcher)
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = wrapContent){
                    height = wrapContent
                }.onClick {
                    finish()
                }
                textView {
                    text = "信息详情"
                    textSize = 18f
                    textColor = Color.WHITE
                    gravity = Gravity.CENTER
                }.lparams {
                    width = dip(0)
                    weight = 1f
                    height = matchParent
                    leftMargin = dip(-48)
                }
            }.lparams(width = matchParent){
                height = dip(54)
            }

            verticalLayout {
                gravity = Gravity.CENTER
                checkBox {
                    isChecked = intent.getBooleanExtra("choose",false)
                }
                textView {
                    text = intent.getStringExtra("content")
                }
            }.lparams(width = matchParent){
                height = wrapContent
            }
        }
    }
}