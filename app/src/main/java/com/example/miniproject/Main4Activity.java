package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }
    public void ChangeActToRechParPrix (View view){
        Intent startIntent =new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(startIntent);
    }
//    public void ChangeActToHome (View view){
//        Intent startIntent =new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(startIntent);
//    }

}
