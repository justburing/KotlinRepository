package zihe.org.www.kotlindemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onItemClick
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val listView: ListView by lazy {
        findViewById(R.id.listView) as ListView
    }
    private val add: FloatingActionButton by lazy {
        findViewById(R.id.add) as FloatingActionButton
    }

    private lateinit var mAdapter: ListViewAdapter
    private lateinit var data: ArrayList<MutableMap<String, Any>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data = ArrayList()
        for (index in 0..10) {
            data.add(mutableMapOf("isChecked" to (index % 2 == 0), "text" to "发言人$index 说：Kotlin会代替Java成为主流的Android编程语言吗？"))
        }
        mAdapter = ListViewAdapter(this, data)
        listView.adapter = mAdapter
        listView.onItemClick { _, _, position, _ ->
            toast("测试")
            val intent: Intent = Intent(ctx, InformationDetailActivity::class.java)
            intent.putExtra("choose", data[position]["isChecked"] as Boolean)
            intent.putExtra("content", data[position]["text"] as String)
            startActivity(intent)
        }
        add.onClick {
            startActivityForResult<EditInfomationActivity>(100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            100 -> when (resultCode) {
                Activity.RESULT_OK -> {
                    this.data.add(mutableMapOf("isChecked" to data!!.getBooleanExtra("choose", false), "text" to "发言人" + this.data.size + "说：Kotlin会代替Java成为主流的Android编程语言吗？"))
                    mAdapter.notifyDataSetChanged()
                }
                else -> return
            }
            else -> toast("没有对应的响应")
        }
    }

    class ListViewAdapter(val context: Context, val data: ArrayList<MutableMap<String, Any>>) : BaseAdapter() {
        override fun getItem(position: Int): Any {
            return data[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return data.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var viewHolder: ViewHolder
            var view: View
            if (convertView?.equals(null) ?: true) {
                view = LayoutInflater.from(context).inflate(R.layout.item_lv, null)
                viewHolder = ViewHolder()
                viewHolder.checkbox = view.findViewById(R.id.checkbox) as CheckBox?
               // viewHolder.checkbox?.isClickable = false
                viewHolder.text = view.findViewById(R.id.text) as TextView
                view.tag = viewHolder
            } else {
                view = convertView!!
                viewHolder = view.tag as ViewHolder
            }
            val map: MutableMap<String, Any> = data[position]
            viewHolder.checkbox?.isChecked = map.getValue("isChecked") as Boolean
            viewHolder.text?.text = map.getValue("text") as CharSequence
            return view

        }

        class ViewHolder {
            var checkbox: CheckBox? = null
            var text: TextView? = null
        }
    }
}
