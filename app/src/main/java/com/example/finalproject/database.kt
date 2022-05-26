package com.example.finalproject

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.core.content.contentValuesOf

val DATABASE_NAME="mydb"
val TABLE_NAME="Currency"
val COL_NAME="name"
val COL_val="value"


class DataBase(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable="CREATE TABLE"+ TABLE_NAME+"("+ COL_NAME+"STRING PRIMARY KEY,"+ COL_val+"DOUBLE)";
        db?.execSQL(createTable)
    }


    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun insertData(currency: currency)
    {
        val db=this.writableDatabase
        var cv= ContentValues()
        cv.put(COL_NAME,currency.name)
        cv.put(COL_val,currency.value)
        var res=db.insert(TABLE_NAME,null,cv)
        if(res==-1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

    }

    fun updatetData(choose2:String,choose3:String,value:Double)
    {
        val text:String=""
        val db=this.writableDatabase
        if (value == 0.0) {
                val text =
                    "UPDATAE " + TABLE_NAME + " SET name = " + choose2 + "Where name=" + choose3 + ""
            }else
        {
            val text =
                "UPDATAE " + TABLE_NAME + " SET value = " + value + "Where name=" + choose3 + ""
        }
        if(text.length==-1)
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        val query=text
        db.rawQuery(query,null)

    }

    fun deletData(choose3:String)
    {

        val db=this.writableDatabase
        val text="DELET FROM"+ TABLE_NAME+"where name = "+choose3

        if(text.length==-1)
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        val query=text
        db.rawQuery(query,null)

    }



}