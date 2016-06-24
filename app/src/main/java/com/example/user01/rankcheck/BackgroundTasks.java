package com.example.user01.rankcheck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;


/**
 * Created by user01 on 6/18/2016.
 */
public class BackgroundTasks extends AsyncTask<Void, Void, Void> {
    Activity currentActivity;

    BackgroundTasks(Activity activity) { this.currentActivity = activity; }
    @Override
    protected Void doInBackground(Void... params) {
        try {
            CurrentGameData.clearAllData();

            // Get player ID number
            JSONObject myJsonObject = JSON.readJsonFromUrl(
                    "https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/"
                            + UserData.getSummonerName()
                            + "?api_key="
                            + API_KEY.key);
            JSONObject nestedIdObject = myJsonObject.getJSONObject(UserData.getSummonerName());
            UserData.setSummonerId( nestedIdObject.getString("id") );

            // Get data of players within current match
            myJsonObject = JSON.readJsonFromUrl(
                    "https://na.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/NA1/"
                            + UserData.getSummonerId()
                            + "?api_key="
                            + API_KEY.key);
            JSONArray participantsArray = myJsonObject.getJSONArray("participants");

            Log.i("Info: ", "Begin Loop");
            String playerId = "";
            String tier = "";
            String division = "";
            for (int i=0; i<10; i++) {
                myJsonObject = participantsArray.getJSONObject(i);
                playerId = myJsonObject.getString("summonerId" );
                Log.i("Adding: ", myJsonObject.getString("summonerName" ));
                CurrentGameData.playerIds.add(playerId);
                CurrentGameData.playersNames.add(myJsonObject.getString("summonerName" ));
                CurrentGameData.championIds.add(myJsonObject.getString("championId" ));
                CurrentGameData.summonerSpell1.add(myJsonObject.getString("spell1Id" ));
                CurrentGameData.summonerSpell2.add(myJsonObject.getString("spell2Id" ));
            }

            String playerIdList = CurrentGameData.playerIds.toString();
            playerIdList = playerIdList.substring(1, playerIdList.length() - 1);
            playerIdList = playerIdList.replaceAll(" ", "" );
            Log.i("PlayerIdList:" , "Created" );
            myJsonObject = JSON.readJsonFromUrl(
                    "https://na.api.pvp.net/api/lol/na/v2.5/league/by-summoner/"
                            + playerIdList
                            + "/entry?api_key="
                            + API_KEY.key);

            for (int i=0; i<10; i++) {
                if (myJsonObject.has("status")) {
                    CurrentGameData.playerTier.add("UNRANKED");
                    CurrentGameData.playerDivision.add("UNRANKED");
                    Log.i("Info", "Unranked Added");
                }

                playerId = CurrentGameData.playerIds.get(i);
                JSONArray player = myJsonObject.getJSONArray(playerId);
                JSONObject tempJsonObject = player.getJSONObject(0);
                tier = tempJsonObject.getString("tier" );

                JSONArray entries = tempJsonObject.getJSONArray("entries");
                tempJsonObject = entries.getJSONObject(0);
                division = tempJsonObject.getString("division" );

                CurrentGameData.playerTier.add(tier);
                CurrentGameData.playerDivision.add(division);
                Log.i("InfO:", "Rank Added" );
            }



        } catch (IOException e) {
            e.printStackTrace();
            Log.i("Error:", "IOException Thrown");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("Error:", "JSONException Thrown");
        }



        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Intent intent = new Intent(currentActivity, RVActivity.class);
        currentActivity.startActivity(intent);
    }
}
