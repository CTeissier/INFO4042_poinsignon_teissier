package org.esiea.poinsignon_teissier.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String lastSelectedCountry = "Sea";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button next = (Button) findViewById(R.id.button);


        ImageButton button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.spain, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test1";
            }

        });

        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.morocco, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test2";
            }

        });

        ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.tunisia, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test3";
            }

        });

        ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.china, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test4";
            }

        });

        ImageButton button5 = (ImageButton) findViewById(R.id.imageButton5);
        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.south_africa, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test5";
            }

        });

        ImageButton button6 = (ImageButton) findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.portugal, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test6";
            }
        });

        ImageButton button7 = (ImageButton) findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.portugal, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test7";
            }
        });

        ImageButton button8 = (ImageButton) findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.portugal, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test8";
            }
        });

        ImageButton button9 = (ImageButton) findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.portugal, Toast.LENGTH_SHORT).show();
                lastSelectedCountry = "Test9";
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.buttonjson) {
            Intent second = new Intent(this, SecondActivity.class);
            startActivity(second);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}