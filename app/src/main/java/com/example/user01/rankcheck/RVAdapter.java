package com.example.user01.rankcheck;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user01 on 6/23/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder> {

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView championImage;
        ImageView summonerSpell1;
        ImageView summonerSpell2;
        TextView playerName;
        TextView playerRank;

        EventViewHolder(View itemView) {
            super(itemView);
//            championImage = (ImageView)itemView.findViewById(R.id.champion_image);
//            summonerSpell1 = (ImageView)itemView.findViewById(R.id.ss1);
//            summonerSpell2 = (ImageView)itemView.findViewById(R.id.ss2);
            playerName = (TextView)itemView.findViewById(R.id.player_name);
            playerRank = (TextView)itemView.findViewById(R.id.player_rank);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_card, viewGroup, false);
        return (new EventViewHolder(v));
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventViewHolder, int i) {
        eventViewHolder.playerName.setText(CurrentGameData.playersNames.get(i));
        String playerRank = CurrentGameData.playerTier.get(i)
                + " "
                + CurrentGameData.playerDivision.get(i);
        eventViewHolder.playerRank.setText(playerRank);
    }

    @Override
    public int getItemCount() {
        return CurrentGameData.playersNames.size();
    }
}
