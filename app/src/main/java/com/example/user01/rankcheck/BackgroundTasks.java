package com.example.user01.rankcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;


public class BackgroundTasks extends AsyncTask<Void, Void, Void> {
    Activity currentActivity;
    boolean allBackgroundTasksComplete = true;
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
            JSONObject nestedIdObject = myJsonObject.getJSONObject(UserData.getSummonerName().toLowerCase());
            UserData.setSummonerId( nestedIdObject.getString("id") );

            // Get data of players within current match
            myJsonObject = JSON.readJsonFromUrl(
                    "https://na.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/NA1/"
                            + UserData.getSummonerId()
                            + "?api_key="
                            + API_KEY.key);
            JSONArray participantsArray = myJsonObject.getJSONArray("participants");
            String playerId;
            String tier;
            String division;
            for (int i=0; i<10; i++) {
                myJsonObject = participantsArray.getJSONObject(i);
                playerId = myJsonObject.getString("summonerId");
                Log.i("Adding: ", myJsonObject.getString("summonerName" ));
                CurrentGameData.playerIds.add(playerId);
                CurrentGameData.playersNames.add(myJsonObject.getString("summonerName" ));
                CurrentGameData.championIds.add(myJsonObject.getString("championId" ));
                CurrentGameData.summonerSpell1.add(myJsonObject.getString("spell1Id" ));
                CurrentGameData.summonerSpell2.add(myJsonObject.getString("spell2Id" ));

                JSONArray runesArray = myJsonObject.getJSONArray("runes");
                ArrayList<Rune> runesList = new ArrayList<>();
                for (int j=0; j<runesArray.length();j++) {
                    String runeId = runesArray.getJSONObject(j).getString("runeId");
                    String count = runesArray.getJSONObject(j).getString("count");
                    Rune rune = new Rune(runeId, count);
                    runesList.add(rune);
                }
                CurrentGameData.runes.add(runesList);

                JSONArray masteriesArray = myJsonObject.getJSONArray("masteries");
                ArrayList<Mastery> masteryList = new ArrayList<>();
                for (int j=0; j<masteriesArray.length(); j++) {
                    String masteryId = masteriesArray.getJSONObject(j).getString("masteryId");
                    String rank = masteriesArray.getJSONObject(j).getString("rank");
                    Mastery mastery = new Mastery(rank, masteryId);
                    masteryList.add(mastery);
                }
                CurrentGameData.masteries.add(masteryList);
            }

            String playerIdList = CurrentGameData.playerIds.toString();
            playerIdList = playerIdList.substring(1, playerIdList.length() - 1);
            playerIdList = playerIdList.replaceAll(" ", "" );
            myJsonObject = JSON.readJsonFromUrl(
                    "https://na.api.pvp.net/api/lol/na/v2.5/league/by-summoner/"
                            + playerIdList
                            + "/entry?api_key="
                            + API_KEY.key);

            // Get player ranks
            for (int i=0; i<10; i++) {
                playerId = CurrentGameData.playerIds.get(i);
                if (myJsonObject.has(playerId)) {
                    JSONArray player = myJsonObject.getJSONArray(playerId);
                    JSONObject tempJsonObject = player.getJSONObject(0);
                    tier = tempJsonObject.getString("tier");

                    JSONArray entries = tempJsonObject.getJSONArray("entries");
                    tempJsonObject = entries.getJSONObject(0);
                    division = tempJsonObject.getString("division");

                    CurrentGameData.playerTier.add(tier);
                    CurrentGameData.playerDivision.add(division);
                }
                else {
                    CurrentGameData.playerTier.add("UNRANKED");
                    CurrentGameData.playerDivision.add(" ");
                }
            }

            // Begin to build Image URLs
            for (int i=0; i<10; i++) {
                // Get current patch
                JSONArray urlArray = JSON.readJsonArrayFromUrl(
                        "https://global.api.pvp.net/api/lol/static-data/na/v1.2/versions?api_key="
                                + API_KEY.key);
                String currPatch = urlArray.getString(0);
                // Get champion key
                JSONObject championInfo = JSON.readJsonFromUrl(
                        "https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion/"
                                + CurrentGameData.championIds.get(i)
                                + "?api_key="
                                + API_KEY.key);
                String championKey = championInfo.getString("key");

                // Get summoner spell 1 key
                JSONObject summonerSpell1Info = JSON.readJsonFromUrl(
                        "https://global.api.pvp.net/api/lol/static-data/na/v1.2/summoner-spell/"
                                + CurrentGameData.summonerSpell1.get(i)
                                + "?api_key="
                                + API_KEY.key);
                String summonerSpell1Key = summonerSpell1Info.getString("key");

                // Get summoner spell 2 key
                JSONObject summonerSpell2Info = JSON.readJsonFromUrl(
                        "https://global.api.pvp.net/api/lol/static-data/na/v1.2/summoner-spell/"
                                + CurrentGameData.summonerSpell2.get(i)
                                + "?api_key="
                                + API_KEY.key);
                String summonerSpell2Key = summonerSpell2Info.getString("key");

                // Building URLs
                String imageURL = "http://ddragon.leagueoflegends.com/cdn/"
                        + currPatch
                        + "/img/champion/"
                        + championKey
                        + ".png";

                String summonerSpell1Url = "http://ddragon.leagueoflegends.com/cdn/"
                        + currPatch
                        + "/img/spell/"
                        + summonerSpell1Key
                        + ".png";

                String summonerSpell2Url = "http://ddragon.leagueoflegends.com/cdn/"
                        + currPatch
                        + "/img/spell/"
                        + summonerSpell2Key
                        + ".png";

                CurrentGameData.championImageUrls.add(imageURL);
                CurrentGameData.summonerSpell1Urls.add(summonerSpell1Url);
                CurrentGameData.summonerSpell2Urls.add(summonerSpell2Url);
            }

        } catch (IOException e) {
            e.printStackTrace();
            allBackgroundTasksComplete = false;
            Log.i("Error:", "IOException Thrown");
        } catch (JSONException e) {
            e.printStackTrace();
            allBackgroundTasksComplete = false;
            Log.i("Error:", "JSONException Thrown");
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (allBackgroundTasksComplete) {
            Log.i("Info", "CHANGING TO RVActivity");
            Intent intent = new Intent(currentActivity, RVActivity.class);
            currentActivity.startActivity(intent);
        }
        else
            Toast.makeText(currentActivity.getApplicationContext(),
                    "This summoner is not currently in a game.",
                    Toast.LENGTH_SHORT).show();
    }
}
// [kevin suks]; }{ pretty butterfly lel :^) }