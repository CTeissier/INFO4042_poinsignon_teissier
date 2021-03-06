package org.esiea.poinsignon_teissier.myproject;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    RecyclerView rv;
    TextView tv_hw;
    DatePickerDialog dpd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        GetInformationsService.startActionGetAllBiers(this);
        IntentFilter intentFilter = new IntentFilter(INFORMATION_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(), intentFilter);
        rv = (RecyclerView) findViewById(R.id.rv_biere);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new BiersAdapter(getBiersFromFile()));
        tv_hw = (TextView) findViewById(R.id.tv_hello_world);
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String dateNow = f.format(date);
        int day = Integer.parseInt(dateNow.substring(0, 2));
        int month = Integer.parseInt(dateNow.substring(3, 5));
        int yeaar = Integer.parseInt(dateNow.substring(6, 10));
        tv_hw.setText(getString(R.string.date) + ":\t " + dateNow);
        dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tv_hw.setText(getString(R.string.date) + ":\t " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        }, yeaar, month - 1, day);

        NotificationManager notifmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int ID = getIntent().getIntExtra("ID", 8);
        notifmanager.cancel(ID);
    }

    public void notification() {
        NotificationCompat.Builder wat =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.emergencycall)
                        .setContentTitle("Notification")
                        .setContentText(getString(R.string.endDL));
        NotificationManager manager = ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE));
        manager.notify(1, wat.build());
    }

    public static final String INFORMATION_UPDATE = "org.esiea.poinsignon_teisser.myproject.action.INFORMATION_UPDATE";

    public class BierUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            BiersAdapter bierAdapt = (BiersAdapter) rv.getAdapter();
            bierAdapt.setNewBiere(getBiersFromFile());
            Log.d("SecondActivity", "" + getIntent().getAction());
            notification();
        }
    }

    public JSONArray getBiersFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    private class BiersAdapter extends RecyclerView.Adapter < BiersAdapter.BierHolder > {

        private JSONArray bieres;

        BiersAdapter(JSONArray biers) {
            this.bieres = biers;
        }

        @Override
        public BierHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new BierHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_bier_element, viewGroup, false));
        }

        public void setNewBiere(JSONArray biers) {
            this.bieres = biers;
            this.notifyDataSetChanged();
        }

        @Override
        public void onBindViewHolder(BierHolder bierHolder, int i) {
            JSONObject object;
            try {
                object = (JSONObject) bieres.get(i);
                String nom = object.getString("name");
                bierHolder.name.setText(nom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return bieres.length();
        }

        public class BierHolder extends RecyclerView.ViewHolder {

            public TextView name;

            public BierHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.rv_bier_element);
            }
        }

    }
}