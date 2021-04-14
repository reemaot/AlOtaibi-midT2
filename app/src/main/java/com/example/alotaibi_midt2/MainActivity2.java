package com.example.alotaibi_midt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText searchEdit = (EditText) findViewById(R.id.searchEdit);
        Button search = (Button) findViewById(R.id.searchbttn);
        Button bttn5 = (Button) findViewById(R.id.button5);

        final Database MyDB = new Database(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(searchEdit.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please enter information", Toast.LENGTH_SHORT).show();
                }
                else{
                    Cursor cur = MyDB.View();
                    StringBuffer buffer = new StringBuffer();

                    while (cur.moveToNext()){

                        buffer.append("ID: "+ cur.getString(0) + "\n");
                        buffer.append("Name: "+ cur.getString(1) + "\n");
                        buffer.append("Email: "+ cur.getString(2) + "\n");
                        buffer.append("Phone: "+ cur.getString(3) + "\n\n");
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                    builder.setCancelable(true);
                    builder.setTitle("All Employees");
                    builder.setMessage(buffer.toString());
                    builder.show();


                }

            }
        });


        bttn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
    }
}