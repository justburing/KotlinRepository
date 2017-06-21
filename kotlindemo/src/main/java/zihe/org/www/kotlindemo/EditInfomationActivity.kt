package zihe.org.www.kotlindemo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RadioButton
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onCheckedChange
import org.jetbrains.anko.sdk25.coroutines.onClick
import zihe.org.www.kotlindemo.R.attr.actionBarSize
import zihe.org.www.kotlindemo.R.attr.layout_anchorGravity

/**
 * Created by BurNIng on 2017/6/9 15：36.
 * Copyright @DC
 */
class EditInfomationActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            //toolbar
            linearLayout {
                backgroundColor = Color.parseColor("#4fc3f7")
                orientation = LinearLayout.HORIZONTAL
                imageView {
                    image = ContextCompat.getDrawable(ctx, R.mipmap.ic_launcher)
                }.lparams(width = wrapContent) {
                    height = wrapContent
                }.onClick {
                    finish()
                }
                textView {
                    text = "新增便签"
                    textSize = 16f
                    textColor = Color.WHITE
                    gravity = Gravity.CENTER
                }.lparams {
                    width = dip(0)
                    weight = 1f
                    leftMargin = dip(-32)
                    height = matchParent
                }
            }.lparams(width = matchParent) {
                height = dip(54)
            }
            //content
            verticalLayout {
                verticalLayout {
                    textView {
                        text = "请选择你以下同意的选项"
                        textSize = 18f
                        gravity = Gravity.CENTER
                    }.lparams {
                        width = matchParent
                    }
                    radioGroup {
                        radioButton {
                            id = 1
                            text = "Java是最好的"
                            textSize = 16f
                            isChecked = false
                        }.lparams(width = matchParent) {
                            height = dip(0)
                            weight = 1f
                            topMargin = dip(8)
                        }
                        radioButton {
                            id = 2
                            text = "Scalar是最好的"
                            textSize = 16f
                            isChecked = false
                        }.lparams(width = matchParent) {
                            height = dip(0)
                            weight = 1f
                            topMargin = dip(8)
                        }
                        radioButton {
                            id = 3
                            text = "Kotlin是最好的"
                            textSize = 16f
                            isChecked = false
                        }.lparams(width = matchParent) {
                            height = dip(0)
                            weight = 1f
                            topMargin = dip(8)
                        }
                        radioButton {
                            id = 4
                            text = "ReactNative是最好的"
                            textSize = 16f
                            isChecked = false
                        }.lparams(width = matchParent) {
                            height = dip(0)
                            weight = 1f
                            topMargin = dip(8)
                        }
                    }.onCheckedChange { group, checkedId ->
                        val intent: Intent = Intent()
                        toast(checkedId?.toString())
                        when (checkedId) {
                            1 -> {
                                toast((group?.getChildAt(0) as RadioButton?)?.text ?: "")
                                intent.putExtra("choose", false)
                                setResult(Activity.RESULT_OK,intent)
                                finish()
                            }
                            2 -> {
                                toast((group?.getChildAt(1) as RadioButton?)?.text ?: "")
                                intent.putExtra("choose", false)
                                setResult(Activity.RESULT_OK,intent)
                                finish()
                            }
                            3 -> {
                                toast((group?.getChildAt(2) as RadioButton?)?.text ?: "")
                                intent.putExtra("choose", true)
                                setResult(Activity.RESULT_OK,intent)
                                finish()
                            }
                            4 -> {
                                toast((group?.getChildAt(3) as RadioButton?)?.text ?: "")
                                intent.putExtra("choose", false)
                                setResult(Activity.RESULT_OK,intent)
                                finish()
                            }
                            else -> {
                                toast("没有选择")
                                return@onCheckedChange
                            }
                        }
                    }
                }.lparams(width = matchParent) {
                    height = wrapContent
                }
            }.lparams {
                width = matchParent
                height = wrapContent
                topMargin = dip(32)
            }
        }
    }
}






