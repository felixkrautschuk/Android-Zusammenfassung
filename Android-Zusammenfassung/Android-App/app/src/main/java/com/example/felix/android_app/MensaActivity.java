package com.example.felix.android_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MensaActivity extends Activity
{
    ImageButton imageButtonMensa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensa);

        imageButtonMensa = (ImageButton) findViewById(R.id.imageButtonMensa);
        registerForContextMenu(imageButtonMensa);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mensa, menu);
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_heute:
                imageButtonMensa.setImageResource(R.drawable.mensa_image);
                return true;
            case R.id.action_woche:
                imageButtonMensa.setImageResource(R.drawable.mensa_image2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
