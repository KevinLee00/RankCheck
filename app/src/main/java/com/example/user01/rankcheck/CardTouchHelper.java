//package com.example.user01.rankcheck;
//
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.helper.ItemTouchHelper;
//
//public class CardTouchHelper extends ItemTouchHelper.SimpleCallback {
//    private RedSideRVAdapter redSideRVAdapter;
//    private PlayersRVAdapter blueSideRVAdapter;
//
//    public CardTouchHelper(RedSideRVAdapter adapter) {
//        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//        this.redSideRVAdapter = adapter;
//    }
//
//    public CardTouchHelper(PlayersRVAdapter adapter) {
//        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//        this.blueSideRVAdapter = adapter;
//    }
//
//    @Override
//    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//
//    }
//
//    @Override
//    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//        redSideRVAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
//        return true;
//    }
//}
