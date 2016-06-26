package com.example.user01.rankcheck;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class RVActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_rv);
        ArrayList<Player> blueSidePlayers = new ArrayList<>();
        ArrayList<Player> redSidePlayers = new ArrayList<>();
        for (int i=0; i<10; i++) {
            Log.i("i=", Integer.toString(i));
            Player player = new Player();
            player.setName(CurrentGameData.playersNames.get(i));
            player.setId(CurrentGameData.playerIds.get(i));
            player.setChampionId(CurrentGameData.championIds.get(i));
            player.setChampionImageUrl(CurrentGameData.championImageUrls.get(i));
            player.setSummonerSpell1(CurrentGameData.summonerSpell1.get(i));
            player.setSummonerSpell1Url(CurrentGameData.summonerSpell1Urls.get(i));
            player.setSummonerSpell2(CurrentGameData.summonerSpell2.get(i));
            player.setSummonerSpell2Url(CurrentGameData.summonerSpell2Urls.get(i));
            player.setPlayerDivision(CurrentGameData.playerDivision.get(i));
            player.setPlayerTier(CurrentGameData.playerTier.get(i));

            if (i < 5) {
                Log.i("Info", "Added to BlueSidePlayers");
                blueSidePlayers.add(player);
            }
            else {
                Log.i("Info", "Added to RedSidePlayers");
                redSidePlayers.add(player);
            }
        }
        Log.i("Info", "Created player object");

        RecyclerView bluesideRV = (RecyclerView) findViewById(R.id.blueside_rv);
        CustomLayoutManager bluesideLayout = new CustomLayoutManager(this);
        bluesideRV.setLayoutManager(bluesideLayout);
        bluesideRV.setNestedScrollingEnabled(false);
        bluesideRV.setHasFixedSize(false);
        PlayersRVAdapter bluesideAdapter = new PlayersRVAdapter(this, blueSidePlayers);
        bluesideRV.setAdapter(bluesideAdapter);

        RecyclerView redsideRV = (RecyclerView) findViewById(R.id.redside_rv);
        CustomLayoutManager redsideLayout = new CustomLayoutManager(this);
        redsideRV.setLayoutManager(redsideLayout);
        redsideRV.setNestedScrollingEnabled(false);
        redsideRV.setHasFixedSize(false);
        PlayersRVAdapter redsideAdapter = new PlayersRVAdapter(this, redSidePlayers);
        redsideRV.setAdapter(redsideAdapter);
    }
}
