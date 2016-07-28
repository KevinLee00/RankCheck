package com.example.user01.rankcheck;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

/**
 * Created by user01 on 7/1/2016.
 */
public class ChildPlayerViewHolder extends ChildViewHolder {
    TextView runeName1;
    TextView runeName2;
    TextView runeName3;
    TextView runeName4;
    TextView runeName5;
    TextView runeName6;
    TextView runeName7;
    TextView runeName8;
    ImageView runeImage1;
    ImageView runeImage2;
    ImageView runeImage3;
    ImageView runeImage4;
    ImageView runeImage5;
    ImageView runeImage6;
    ImageView runeImage7;
    ImageView runeImage8;


    ChildPlayerViewHolder(View itemView) {
        super(itemView);
        runeName1 = (TextView) itemView.findViewById(R.id.rune_name1);
        runeName2 = (TextView) itemView.findViewById(R.id.rune_name2);
        runeName3 = (TextView) itemView.findViewById(R.id.rune_name3);
        runeName4 = (TextView) itemView.findViewById(R.id.rune_name4);
        runeName5 = (TextView) itemView.findViewById(R.id.rune_name5);
        runeName6 = (TextView) itemView.findViewById(R.id.rune_name6);
        runeName7 = (TextView) itemView.findViewById(R.id.rune_name7);
        runeName8 = (TextView) itemView.findViewById(R.id.rune_name8);

        runeImage1 = (ImageView) itemView.findViewById(R.id.rune_image1);
        runeImage2 = (ImageView) itemView.findViewById(R.id.rune_image2);
        runeImage3 = (ImageView) itemView.findViewById(R.id.rune_image3);
        runeImage4 = (ImageView) itemView.findViewById(R.id.rune_image4);
        runeImage5 = (ImageView) itemView.findViewById(R.id.rune_image5);
        runeImage6 = (ImageView) itemView.findViewById(R.id.rune_image6);
        runeImage7 = (ImageView) itemView.findViewById(R.id.rune_image7);
        runeImage8 = (ImageView) itemView.findViewById(R.id.rune_image8);
    }

}
