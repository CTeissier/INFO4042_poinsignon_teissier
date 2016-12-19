package org.esiea.poinsignon_teissier.myproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeliveryForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryform);
        Button confirm = (Button) findViewById(R.id.button3);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.editText);
                Editable first_name = text.getText();
                EditText text2 = (EditText) findViewById(R.id.editText2);
                Editable last_name = text2.getText();
                EditText text3 = (EditText) findViewById(R.id.editText3);
                Editable email = text3.getText();
                EditText text4 = (EditText) findViewById(R.id.editText4);
                Editable phone = text4.getText();
                Intent i = new Intent(getApplicationContext(), NotificationPush.class);
                i.putExtra("emergency", getIntent().getStringExtra("emergency"));
                i.putExtra("first_name", first_name.toString());
                i.putExtra("last_name", last_name.toString());
                i.putExtra("adress", email.toString());
                i.putExtra("phone_number", phone.toString());
                startActivity(i);
            }
        });
    }

    @Override
    public Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplication());
        builder.setMessage("123")
                .setPositiveButton("go", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}