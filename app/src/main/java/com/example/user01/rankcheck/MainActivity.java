package com.example.user01.rankcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testToast(View view) {
//        TextView tv = (TextView) findViewById(R.id.textView);
        EditText et = (EditText) findViewById(R.id.summoner_name);
        String name = et.getText().toString().replaceAll("\\s+","");
        UserData.setSummonerName(name);

        BackgroundTasks bt = new BackgroundTasks(MainActivity.this);
        bt.execute();

    }
}