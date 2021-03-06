package com.android.example.testsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.next_activity_button)
    Button nextActivityButton;
    @BindView(R.id.exit_button)
    Button exitButton;
    @BindView(R.id.editText)
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        nextActivityButton.setOnClickListener(this);

        exitButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {


            case R.id.next_activity_button:
                if(editText.getText().toString().toLowerCase().equals("magic word")){
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }
                break;


            case R.id.exit_button:
                finish();
                break;
        }

    }
}
