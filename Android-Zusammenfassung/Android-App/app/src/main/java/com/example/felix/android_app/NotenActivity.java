package com.example.felix.android_app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class NotenActivity extends Activity
{
    TextView notenInfo;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noten);
        notenInfo = (TextView) findViewById(R.id.textViewNotenInfo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.noten, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_aktualisieren)
        {
            ProgressAsyncTask task = new ProgressAsyncTask();
            task.execute("");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class ProgressAsyncTask extends AsyncTask<String, Integer, String>
    {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute()
        {
            dialog = new ProgressDialog(NotenActivity.this);
            dialog.setMessage("Es wird nach neuen Noten gesucht...");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(100);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params)
        {
            for (int i = 0; i < 50; i++)
            {
                publishProgress(2);
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            dialog.incrementProgressBy(values[0]);
        }

        protected void onPostExecute(String result)
        {
            dialog.dismiss();
        }
    }
}