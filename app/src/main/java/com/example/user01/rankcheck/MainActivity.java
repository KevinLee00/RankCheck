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
//        BackgroundTasks bt = new BackgroundTasks(MainActivity.this);
//        bt.execute();
    }

    public void testToast(View view) {
        TextView tv = (TextView) findViewById(R.id.textView);
        EditText et = (EditText) findViewById(R.id.summoner_name);
        String name = et.getText().toString().replaceAll("\\s+","");
        UserData.setSummonerName(name);

        BackgroundTasks bt = new BackgroundTasks(MainActivity.this);
        bt.execute();

        String players = CurrentGameData.playersNames.toString().replaceAll(",", "\n");
        tv.setText(players);
        Toast.makeText(getApplicationContext(), players, Toast.LENGTH_SHORT).show();
    }
}