package com.example.finalproject
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ins: Button= findViewById(R.id.insert)
        val value: EditText= findViewById(R.id.value)
        val txt: EditText= findViewById(R.id.curr)
        val context=this
        var db= DataBase(context)
        val chose: Spinner= findViewById(R.id.choose)
        val chose1: Spinner= findViewById(R.id.choose)
        var flag : String =" "

        ins.setOnClickListener({
            if(txt.text.toString().length>0 && value.text.toString().length>0)
            {
                var d = currency(txt.text.toString(), value.text.toString().toDouble())

                db.insertData(d)
                var options = arrayOf(txt.toString())
                chose.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
                chose.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        flag = options.get(p2)
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
                chose1.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
                chose1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        flag = options.get(p2)
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
            }
            else
            {
                Toast.makeText(context, "Please fiil all data's", Toast.LENGTH_SHORT).show()
            }
        })
        var spin:Spinner = this.findViewById(R.id.choose)


        val upd: Button= findViewById(R.id.update)


        val txt1: EditText= findViewById(R.id.eupchosee2)
        upd.setOnClickListener(
            {
                if(txt1.toString().isDigitsOnly() )
                    db.updatetData(" ",chose.selectedItem.toString(),txt1.toString().toDouble())
                else
                    db.updatetData(txt1.toString(),chose.selectedItem.toString(),0.0)

            }

        )
        val del: Button= findViewById(R.id.update)
        del.setOnClickListener(
            {

                    chose.removeViewAt(chose1.selectedItemPosition)
                    chose1.removeViewAt(chose1.selectedItemPosition)
                    db.deletData(chose1.selectedItem.toString())
            }

        )
    }

}
