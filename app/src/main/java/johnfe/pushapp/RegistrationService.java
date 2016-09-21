package johnfe.pushapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;


/**
 * Created by Johnfe Vargas on 2016-09-21.
 */
public class RegistrationService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public RegistrationService() {
        super("RegistrationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        InstanceID myID = InstanceID.getInstance(this);

        String registrationToken = null;
        try {
            registrationToken = myID.getToken(
                    getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE,
                    null
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("Registration Token", registrationToken);

    }
}
