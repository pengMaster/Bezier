package com.example.bezier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bezier.bezier2.Bezier2;
import com.example.bezier.bezier2.Bezier2Act;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bezier2(View view) {
        startActivity(new Intent(getApplicationContext(), Bezier2Act.class));
    }
}
