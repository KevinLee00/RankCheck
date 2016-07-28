package com.example.user01.rankcheck;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user01 on 7/1/2016.
 */
public class ExpandablePlayerAdapter extends ExpandableRecyclerAdapter<PlayerViewHolder,ChildPlayerViewHolder> {
    ArrayList<ParentObject> players;
    Context context;


    public ExpandablePlayerAdapter(Context context, ArrayList<ParentObject> parentItemList) {
        super(context, parentItemList);
        players = parentItemList;
        this.context = context;
    }

    @Override
    public PlayerViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_card, viewGroup, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(PlayerViewHolder playerViewHolder, int i, Object o) {
        Player player = (Player) o;
        playerViewHolder.playerName.setText(player.getName());
        String playerRank = player.getPlayerTier() + " " + player.getPlayerDivision();
        playerViewHolder.playerRank.setText(playerRank);
        Picasso.with(context).load(player.getChampionImageUrl()).into(playerViewHolder.championImage);
        Picasso.with(context).load(player.getSummonerSpell1Url()).into(playerViewHolder.summonerSpell1);
        Picasso.with(context).load(player.getSummonerSpell2Url()).into(playerViewHolder.summonerSpell2);
    }
    @Override
    public ChildPlayerViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expanded_card_layout, viewGroup, false);
        return new ChildPlayerViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildPlayerViewHolder childViewHolder, int i, Object o) {
        Player player = (Player) o;
        Picasso.with(context).load(player.getChampionImageUrl()).into(childViewHolder.runeImage1);
    }
}
