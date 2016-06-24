package com.example.user01.rankcheck;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by user01 on 6/23/2016.
 */
public class RVActivity extends Activity {
    private RecyclerView playerRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_rv);

        playerRV = (RecyclerView) findViewById(R.id.player_rv);

        LinearLayoutManager playerLayout = new LinearLayoutManager(this);
        playerRV.setLayoutManager(playerLayout);

        RVAdapter playerAdapter = new RVAdapter();
        playerRV.setAdapter(playerAdapter);
    }
}
