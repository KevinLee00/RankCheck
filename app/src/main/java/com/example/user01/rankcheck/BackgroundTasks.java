package com.example.user01.rankcheck;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;


/**
 * Created by user01 on 6/18/2016.
 */
public class BackgroundTasks extends AsyncTask<Void, Void, Void> {
    Context myContext;

    BackgroundTasks(Context context) { this.myContext = context; }
    @Override
    protected Void doInBackground(Void... params) {
        try {
            CurrentGameData.clearAllData();
            JSONObject myJsonObject = JSON.readJsonFromUrl(
                    "https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/"
                            + UserData.getSummonerName()
                            + "?api_key=618fccee-ac1d-41f6-b1d3-98e670f594ad");
            JSONObject nestedIdObject = myJsonObject.getJSONObject(UserData.getSummonerName());
            UserData.setSummonerId( nestedIdObject.getString("id") );

            myJsonObject = JSON.readJsonFromUrl(
                    "https://na.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/NA1/"
                            + UserData.getSummonerId()
                            + "?api_key=618fccee-ac1d-41f6-b1d3-98e670f594ad");
            JSONArray nestedParticipantsArray = myJsonObject.getJSONArray("participants");

            for (int i=0; i<nestedParticipantsArray.length(); i++) {
                myJsonObject = nestedParticipantsArray.getJSONObject(i);
                CurrentGameData.playerIds.add(myJsonObject.getString("summonerId"));
                CurrentGameData.playersNames.add(myJsonObject.getString("summonerName"));
                CurrentGameData.championIds.add(myJsonObject.getString("championId"));
                CurrentGameData.summonerSpell1.add(myJsonObject.getString("spell1Id"));
                CurrentGameData.summonerSpell2.add(myJsonObject.getString("spell2Id"));
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
    }
}
