package com.example.alotaibi_midt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
 String inputData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final Database MyDB = new Database(this);

        EditText input = (EditText) findViewById(R.id.input);
        Button getDataBttn = (Button) findViewById(R.id.button6);
        Button deletebttn = (Button) findViewById(R.id.button7);
        TextView result = (TextView) findViewById(R.id.resultInput);

        getDataBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity3.this, "Please enter information", Toast.LENGTH_SHORT).show();
                } else{

                    Cursor cur = MyDB.View();
                    StringBuffer buffer = new StringBuffer();

                    while (cur.moveToNext()){

                        buffer.append("ID: "+ cur.getString(0) + "\n");
                        buffer.append("Name: "+ cur.getString(1) + "\n");
                        buffer.append("Email: "+ cur.getString(2) + "\n");
                        buffer.append("Phone: "+ cur.getString(3) + "\n\n");
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                    builder.setCancelable(true);
                    builder.setTitle("All Employees");
                    builder.setMessage(buffer.toString());
                    builder.show();

                    Toast.makeText(MainActivity3.this, "Successful View", Toast.LENGTH_LONG).show();


                }
            }
        });


        deletebttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData = input.getText().toString();
                MyDB.Delete(inputData);

                Toast.makeText(MainActivity3.this, "Successful Delete", Toast.LENGTH_LONG).show();
            }
        });

    }
}