package com.example.alotaibi_midt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String id_val;
    String name_val;
    String email_val;
    int phone_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText id = (EditText) findViewById(R.id.idEdit);
        EditText name = (EditText) findViewById(R.id.nameEdit);
        EditText email = (EditText) findViewById(R.id.emailEdit);
        EditText phone = (EditText) findViewById(R.id.phoneEdit);
        Button insert= (Button) findViewById(R.id.insert);
        Button bttn2 = (Button) findViewById(R.id.button2);
        Button bttn3 = (Button) findViewById(R.id.button3);

        final Database MyDB = new Database(this);

        if(id.getText().toString().isEmpty() || name.getText().toString().isEmpty() || email.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter Information ", Toast.LENGTH_SHORT).show();
        }
        else{

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id_val = id.getText().toString();
                name_val = name.getText().toString();
                phone_val = Integer.parseInt(phone.getText().toString());
                email_val = email.getText().toString();

                MyDB.Add( id_val, name_val, phone_val, email_val);
                Toast.makeText(MainActivity.this, "Successful Add", Toast.LENGTH_LONG).show();
            }
        });


            bttn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                }
            });


            bttn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, MainActivity3.class));
                }
            });
        }

    }
}