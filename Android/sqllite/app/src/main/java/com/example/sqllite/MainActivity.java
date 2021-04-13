package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button b1=findViewById(R.id.button);
        Button b2=findViewById(R.id.button2);
        Button b3=findViewById(R.id.button3);
        Button b4=findViewById(R.id.button4);
        Button b5=findViewById(R.id.button5);
        EditText editname=findViewById(R.id.editTextTextPersonName);
        EditText editpwd=findViewById(R.id.editTextTextPassword3);
        TextView textView2=findViewById(R.id.textView2);
        MyHelper myHelper = new MyHelper(this,"book1.db",null,2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String name=editname.getText().toString().trim();
            String pwd=editpwd.getText().toString().trim();
            SQLiteDatabase db= myHelper.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("category_name",name);
            values.put("category_code",pwd);
            db.insert("Category",null,values);
            Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db= myHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("category_code",editpwd.getText().toString().trim());
                db.update("Category",values,"category_name=?",new String[]{editname.getText().toString().trim()});
                Toast.makeText(MainActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db= myHelper.getWritableDatabase();
                db.delete("Category","category_name=?",new String[]{editname.getText().toString()});
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText("");
                SQLiteDatabase db= myHelper.getWritableDatabase();
                Cursor cursor=db.query("Category",null,null,null,null,null,null);
                while (cursor.moveToNext()){
                    textView2.append(cursor.getString(1)+"--"+cursor.getString(2)+"\n");
                }
                cursor.close();
                Toast.makeText(MainActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHelper.getWritableDatabase();
                Toast.makeText(MainActivity.this,"创建成功",Toast.LENGTH_SHORT).show();
            }
        });


    }
}