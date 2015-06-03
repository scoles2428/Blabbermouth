package samcoles.blabbermouth.samcoles.blabbermouth.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import samcoles.blabbermouth.R;


public class ViewImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        setupActionBar();

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        Uri imageUri = getIntent().getData();

        Picasso.with(this).load(imageUri.toString()).rotate(90).into(imageView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
             @Override
             public void run() {
                   finish();
             }
           }, 15*1000);
    }

    private void setupActionBar() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_send) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
