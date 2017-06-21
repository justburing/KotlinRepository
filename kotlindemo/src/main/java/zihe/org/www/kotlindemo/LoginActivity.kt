package zihe.org.www.kotlindemo

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

/**
 * Created by BurNIng on 2017/6/8 16：16.
 * Copyright @DC
 * Desc 登录类
 */
class LoginActivity : AppCompatActivity() {
    private val userName: TextInputLayout by lazy {
        findViewById(R.id.userName) as TextInputLayout
    }
    private lateinit var userPassord: TextInputLayout
    private var login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userPassord = find(R.id.userPassword)
        login = findViewById(R.id.login) as Button
        login?.setBackgroundColor(Color.parseColor("#00acc1"))
        login!!.text = "马上登录啦"
        login?.setOnClickListener {
            val userNameText: String? = userName.editText?.text.toString()
            val userPasswordText: String? = userPassord.editText?.text.toString()
            if (userNameText?.equals("") ?: true || userPasswordText?.equals("") ?: true) {
                val snackBar: Snackbar
                        = Snackbar.make(LoginActivity@ this.findViewById(R.id.view), "账号或密码为空", 1000)
                        .setAction("确定", {
                            when {
                                userNameText?.equals("") ?: true -> userName.requestFocus()
                                else -> userPassword.requestFocus()
                            }
                        })
                snackBar.show()
            } else {
                when {
                    userNameText.equals("test") && userPasswordText.equals("123456")
                        -> startActivity(Intent(LoginActivity@ this, MainActivity::class.java))
                    else -> toast("账号密码错啦...")
                }
            }
        }
    }
}