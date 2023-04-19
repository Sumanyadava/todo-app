package com.example.listad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText e1,e2,e3;
    Button b1;

    SharedPreferences s1;

    String namestr,emailstr,passstr;

//    function auto call to check the data is here or nor



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        e1 = findViewById(R.id.editTextTextPersonName);
        e2 = findViewById(R.id.editTextTextPersonName2);
        e3 = findViewById(R.id.editTextTextPersonName3);
        b1 = findViewById(R.id.button);


        s1 = getSharedPreferences("myUser", Context.MODE_PRIVATE);



        autologin();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namestr = e1.getText().toString();
                emailstr = e2.getText().toString();
                passstr = e3.getText().toString();



                 SharedPreferences.Editor editor = s1.edit();
                editor.putString("name",namestr);
                editor.putString("email",emailstr);
                editor.putString("pass",passstr);
                editor.commit();
                Toast.makeText(MainActivity.this, "there is no going back"+namestr, Toast.LENGTH_LONG).show();

                Intent i1 = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(i1);
                finish();


            }
        });


    }

    private void autologin() {


        SharedPreferences sharedPreferences = s1; //todo look herre
        String check = sharedPreferences.getString("name","");
//        Toast.makeText(this, "asfasfasfasfasf "+namestr, Toast.LENGTH_SHORT).show();
        if (check != ""){

            Toast.makeText(this, "going "+check, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(i1);
            finish();
        }

    }
}