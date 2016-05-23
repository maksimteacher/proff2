package com.example.myapp;

import com.example.myapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity{
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        text = (EditText) findViewById(R.id.text1);


    }
    public void myClick(View view){
        text.setText("My message");
    }
    public void myClickRedirect(View view){
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra("par1", "value of par1");
        startActivity(intent);
    }
}
