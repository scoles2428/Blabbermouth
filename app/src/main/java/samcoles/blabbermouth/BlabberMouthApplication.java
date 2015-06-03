package samcoles.blabbermouth;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

import samcoles.blabbermouth.samcoles.blabbermouth.ui.MainActivity;
import samcoles.blabbermouth.samcoles.blabbermouth.utilities.ParseConstants;

/**
 * Created by Sam on 18/11/2014.
 */
public class BlabberMouthApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "QNGLgjgps5Gakijgb9L3VYZM0pXARnkZc48yuRA8", "sMQh4HtjZxLkMCNf1DJW3g45JhFUBL4lNooBM9vM");


        // Also in this method, specify a default Activity to handle push notifications
        // PushService.setDefaultPushCallback(this, MainActivity.class);
        PushService.setDefaultPushCallback(this, MainActivity.class, R.drawable.ic_stat_ic_launcher);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        }

        public static void updateParseInstallation(ParseUser user) {
            ParseInstallation installation = ParseInstallation.getCurrentInstallation();
            installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
            installation.saveInBackground();
        }

}
