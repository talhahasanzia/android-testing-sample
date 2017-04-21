package com.android.example.testsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener
{

    @BindView(R.id.random_button) Button randomButton;
    @BindView(R.id.finish_button) Button finishButton;


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        ButterKnife.bind( this );

        randomButton.setOnClickListener( this );
        finishButton.setOnClickListener( this );


    }

    @Override public void onClick( View view )
    {
        switch ( view.getId() )
        {


            case R.id.random_button:


                String text = "RANDOM NUMBER " + generateRandomNumber();

                randomButton.setText( text );
                break;


            case R.id.finish_button:
                finish();
                break;

        }
    }

    int generateRandomNumber()
    {

        Random rn = new Random();
        int range = 10 - 1 + 1;
        return rn.nextInt( range ) + 1;
    }
}
