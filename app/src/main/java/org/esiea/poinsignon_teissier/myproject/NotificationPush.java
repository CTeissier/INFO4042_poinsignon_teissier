package org.esiea.poinsignon_teissier.myproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NotificationPush extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationpush);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new ConfirmationDialog().show(getFragmentManager(), "hmm");
        final Bundle sharedPrefs = getIntent().getExtras();


                Button jsonButton = (Button) findViewById(R.id.buttonjson);
        jsonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Vous venez de télécharger la liste des informations utiles", Toast.LENGTH_SHORT).show();
                NotificationCompat.Builder notification = new NotificationCompat.Builder(NotificationPush.this);
                notification.setSmallIcon(R.drawable.information);
                notification.setTicker("Téléchargement effectué");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Informations utiles");
                notification.setContentText("Gardez votre téléphone près de vous ");
                Uri sound = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
                notification.setSound(sound);
                Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.information);
                notification.setLargeIcon(picture);
                PendingIntent myPendingIntent;
                Intent myIntent = new Intent();
                Context myContext = getApplicationContext();
                myIntent.setClass(myContext, SecondActivity.class);
                myIntent.putExtra("ID", 1);
                myPendingIntent = PendingIntent.getActivity(myContext, 0, myIntent, 0);
                notification.setContentIntent(myPendingIntent);
                Notification notif = notification.build();
                NotificationManager notifmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notifmanager.notify(1, notif);
            }
        });

    }
}