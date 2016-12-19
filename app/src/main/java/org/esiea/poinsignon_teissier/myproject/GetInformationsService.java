package org.esiea.poinsignon_teissier.myproject;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetInformationsService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String GETALLBIERS = "org.esiea.poinsignon_teisser.myproject.action.GETALLBIERS";

    public GetInformationsService() {
        super("GetInformationsService");
    }

    public static void startActionGetAllBiers(Context context) {
        Intent intent = new Intent(context, GetInformationsService.class);
        intent.setAction(GETALLBIERS);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (GETALLBIERS.equals(action)) {
                handleActionGetAllBiers();
            }
        }
    }

    private void copyInputStreamToFile(InputStream in , File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in .read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleActionGetAllBiers() {

        Log.d("GetBiersServices", "Thread service name:" + Thread.currentThread().getName());
        URL url = null;
        try {
            url = new URL("https://api.myjson.com/bins/syzop");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                copyInputStreamToFile(conn.getInputStream(), new File(getCacheDir(), "bieres.json"));
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(SecondActivity.INFORMATION_UPDATE));

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}