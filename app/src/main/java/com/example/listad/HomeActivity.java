package com.example.listad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences s1;


    TextView t1,t2,t3;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        t3 = findViewById(R.id.textView4);
        b2 = findViewById(R.id.button2);
        s1 = getApplicationContext().getSharedPreferences("myUser", Context.MODE_PRIVATE);


        String name = s1.getString("name","");
        String email = s1.getString("email","");
        String pass =s1.getString("pass","");


            t1.setText(name);
            t2.setText(email);
            t3.setText(pass);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = s1.edit();
                editor.clear();
                editor.commit();

                Toast.makeText(HomeActivity.this, "you did it", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
                finish();
            }
        });
    }
}