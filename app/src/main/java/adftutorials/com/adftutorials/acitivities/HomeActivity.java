package adftutorials.com.adftutorials.acitivities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import adftutorials.com.adftutorials.R;
import adftutorials.com.adftutorials.fragments.AdfPost;
import adftutorials.com.adftutorials.logging.L;

public class HomeActivity extends ActionBarActivity {

    private Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mtoolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        if(savedInstanceState==null)
        {
            L.m("Inside main activity check save state.");
            AdfPost first=AdfPost.newInstance("","");

            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction=fm.beginTransaction();
            transaction.add(R.id.frame_container,first);
            transaction.commit();
        }
        L.m("outside save state.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
