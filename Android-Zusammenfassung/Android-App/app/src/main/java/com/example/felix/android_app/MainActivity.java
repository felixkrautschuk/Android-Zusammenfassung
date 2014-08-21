package com.example.felix.android_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends Activity implements View.OnClickListener
{
    ImageButton buttonStundenplan;
    ImageButton buttonNoten;
    ImageButton buttonMensa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStundenplan = (ImageButton) findViewById(R.id.mainBottomActionBar_imageButton_stundenplan);
        buttonNoten = (ImageButton) findViewById(R.id.mainBottomActionBar_imageButton_noten);
        buttonMensa = (ImageButton) findViewById(R.id.mainBottomActionBar_imageButton_mensa);

        buttonStundenplan.setOnClickListener(this);
        buttonNoten.setOnClickListener(this);
        buttonMensa.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.mainBottomActionBar_imageButton_stundenplan:
                startActivity(new Intent(this, StundenplanActivity.class));
                break;
            case R.id.mainBottomActionBar_imageButton_noten:
                startActivity(new Intent(this, NotenActivity.class));
                break;
            case R.id.mainBottomActionBar_imageButton_mensa:
                startActivity(new Intent(this, MensaActivity.class));
                break;
            default:
                break;
        }
    }
}
