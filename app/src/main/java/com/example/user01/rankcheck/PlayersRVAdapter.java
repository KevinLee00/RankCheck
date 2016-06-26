package com.example.user01.rankcheck;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class PlayersRVAdapter extends RecyclerView.Adapter<PlayersRVAdapter.EventViewHolder> {
    Context context;
    ArrayList<Player> players = new ArrayList<>();

    public PlayersRVAdapter(Context context, ArrayList<Player> playersList) {
        this.context = context;
        this.players = playersList;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageView championImage;
        ImageView summonerSpell1;
        ImageView summonerSpell2;
        TextView playerName;
        TextView playerRank;
        ImageView rankEmblem;

        EventViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            championImage = (ImageView)itemView.findViewById(R.id.champion_image);
            summonerSpell1 = (ImageView)itemView.findViewById(R.id.ss1);
            summonerSpell2 = (ImageView)itemView.findViewById(R.id.ss2);
            playerName = (TextView)itemView.findViewById(R.id.player_name);
            playerRank = (TextView)itemView.findViewById(R.id.player_rank);
            rankEmblem = (ImageView)itemView.findViewById(R.id.rank_emblem);
        }

        public void loadImage(int i) {
            Picasso.with(context).load(CurrentGameData.championImageUrls.get(i)).into(championImage);
            Picasso.with(context).load(CurrentGameData.summonerSpell1Urls.get(i)).into(summonerSpell1);
            Picasso.with(context).load(CurrentGameData.summonerSpell2Urls.get(i)).into(summonerSpell2);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_card, viewGroup, false);
        return (new EventViewHolder(v,context));
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventViewHolder, int i) {
        eventViewHolder.playerName.setText(players.get(i).getName());
        String playerRank = players.get(i).getPlayerTier() + " " + players.get(i).getPlayerDivision();
        eventViewHolder.playerRank.setText(playerRank);
        Picasso.with(context).load(players.get(i).getChampionImageUrl()).into(eventViewHolder.championImage);
        Picasso.with(context).load(players.get(i).getSummonerSpell1Url()).into(eventViewHolder.summonerSpell1);
        Picasso.with(context).load(players.get(i).getSummonerSpell2Url()).into(eventViewHolder.summonerSpell2);
        String rank = players.get(i).getPlayerTier();

        if (rank.equals("BRONZE"))
            Picasso.with(context).load(R.drawable.bronze).into(eventViewHolder.rankEmblem);
        else if (rank.equals("SILVER"))
            Picasso.with(context).load(R.drawable.silver).into(eventViewHolder.rankEmblem);
        else if (rank.equals("GOLD"))
            Picasso.with(context).load(R.drawable.gold).into(eventViewHolder.rankEmblem);
        else if (rank.equals("PLATINUM"))
            Picasso.with(context).load(R.drawable.plat).into(eventViewHolder.rankEmblem);
        else if (rank.equals("DIAMOND"))
            Picasso.with(context).load(R.drawable.diamond).into(eventViewHolder.rankEmblem);
        else if (rank.equals("MASTER"))
            Picasso.with(context).load(R.drawable.master).into(eventViewHolder.rankEmblem);
        else if (rank.equals("CHALLENGER"))
            Picasso.with(context).load(R.drawable.challenger).into(eventViewHolder.rankEmblem);
        else
            Picasso.with(context).load(R.drawable.unranked).into(eventViewHolder.rankEmblem);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
