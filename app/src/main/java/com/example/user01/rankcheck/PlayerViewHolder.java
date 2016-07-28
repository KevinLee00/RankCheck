package com.example.user01.rankcheck;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

/**
 * Created by user01 on 7/1/2016.
 */


public class PlayerViewHolder extends ParentViewHolder {
    ImageView championImage;
    ImageView summonerSpell1;
    ImageView summonerSpell2;
    TextView playerName;
    TextView playerRank;
    ImageView rankEmblem;

    PlayerViewHolder(View itemView) {
        super(itemView);
        championImage = (ImageView) itemView.findViewById(R.id.champion_image);
        summonerSpell1 = (ImageView) itemView.findViewById(R.id.ss1);
        summonerSpell2 = (ImageView) itemView.findViewById(R.id.ss2);
        playerName = (TextView) itemView.findViewById(R.id.player_name);
        playerRank = (TextView) itemView.findViewById(R.id.player_rank);
        rankEmblem = (ImageView) itemView.findViewById(R.id.rank_emblem);
    }
}

