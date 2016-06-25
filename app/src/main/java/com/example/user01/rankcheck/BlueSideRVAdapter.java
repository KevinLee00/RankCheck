package com.example.user01.rankcheck;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class BlueSideRVAdapter extends RecyclerView.Adapter<BlueSideRVAdapter.EventViewHolder> {
    Context context;

    BlueSideRVAdapter(Context context) {
        this.context = context;
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

            String rank = CurrentGameData.playerTier.get(i);

            if (rank.equals("BRONZE"))
                Picasso.with(context).load(R.drawable.bronze).into(rankEmblem);
            else if (rank.equals("SILVER"))
                Picasso.with(context).load(R.drawable.silver).into(rankEmblem);
            else if (rank.equals("GOLD"))
                Picasso.with(context).load(R.drawable.gold).into(rankEmblem);
            else if (rank.equals("PLATINUM"))
                Picasso.with(context).load(R.drawable.plat).into(rankEmblem);
            else if (rank.equals("DIAMOND"))
                Picasso.with(context).load(R.drawable.diamond).into(rankEmblem);
            else if (rank.equals("MASTER"))
                Picasso.with(context).load(R.drawable.master).into(rankEmblem);
            else if (rank.equals("CHALLENGER"))
                Picasso.with(context).load(R.drawable.challenger).into(rankEmblem);
            else
                Picasso.with(context).load(R.drawable.unranked).into(rankEmblem);

//            switch(CurrentGameData.playerTier.get(i)) {
//                case("BRONZE"):
//                    Picasso.with(context).load(R.drawable.bronze).into(rankEmblem);
//                case("SILVER"):
//                    Picasso.with(context).load(R.drawable.silver).into(rankEmblem);
//                case("GOLD"):
//                    Picasso.with(context).load(R.drawable.gold).into(rankEmblem);
//                case("PLATINUM"):
//                    Picasso.with(context).load(R.drawable.plat).into(rankEmblem);
//                case("DIAMOND"):
//                    Picasso.with(context).load(R.drawable.diamond).into(rankEmblem);
//                case("MASTER"):
//                    Picasso.with(context).load(R.drawable.master).into(rankEmblem);
//                case("CHALLENGER"):
//                    Picasso.with(context).load(R.drawable.challenger).into(rankEmblem);
//                default:
//                    Picasso.with(context).load(R.drawable.unranked).into(rankEmblem);
//            }
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
        eventViewHolder.playerName.setText(CurrentGameData.playersNames.get(i));
        String playerRank = CurrentGameData.playerTier.get(i)
                + " "
                + CurrentGameData.playerDivision.get(i);
        eventViewHolder.playerRank.setText(playerRank);
        eventViewHolder.loadImage(i);
    }

    @Override
    public int getItemCount() {
        return CurrentGameData.playersNames.size()/2;
    }
}
