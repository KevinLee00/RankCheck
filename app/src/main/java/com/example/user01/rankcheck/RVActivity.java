package com.example.user01.rankcheck;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class RVActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_rv);

        RecyclerView bluesideRV = (RecyclerView) findViewById(R.id.blueside_rv);
        RecyclerView redsideRV = (RecyclerView) findViewById(R.id.redside_rv);
        CustomLayoutManager bluesideLayout = new CustomLayoutManager(this);
        bluesideRV.setLayoutManager(bluesideLayout);
        CustomLayoutManager redsideLayout = new CustomLayoutManager(this);
        redsideRV.setLayoutManager(redsideLayout);

        bluesideRV.setNestedScrollingEnabled(false);
        bluesideRV.setHasFixedSize(false);
        redsideRV.setNestedScrollingEnabled(false);
        redsideRV.setHasFixedSize(false);

        BlueSideRVAdapter bluesideAdapter = new BlueSideRVAdapter(this);
        bluesideRV.setAdapter(bluesideAdapter);
        RedSideRVAdapter redsideAdapter = new RedSideRVAdapter(this);
        redsideRV.setAdapter(redsideAdapter);

        Toast.makeText(this, CurrentGameData.playerTier.toString(), Toast.LENGTH_SHORT).show();
    }
}
