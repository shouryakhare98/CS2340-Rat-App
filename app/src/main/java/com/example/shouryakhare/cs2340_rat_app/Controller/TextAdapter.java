package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.Model.RatSighting;
import com.example.shouryakhare.cs2340_rat_app.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.shouryakhare.cs2340_rat_app.R.layout.list_item_text;

/**
 * Created by shouryakhare on 10/9/17.
 * Adapter to populate recycler view.
 */

public class TextAdapter extends RecyclerView.Adapter {

    private List<RatSighting> mRatList = new ArrayList<>();
    private List<String> mList = new ArrayList<>();

    void setItems(List<RatSighting> list) {
        mRatList = list;
        for (RatSighting sighting : mRatList) {
            mList.add(sighting.toString());
        }

        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return TextViewHolder.inflate(parent);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).bind(mList.get(position));

            ((TextViewHolder) holder).linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent loginIntent = new Intent(view.getContext(), ExpandedRatSightingActivity.class);
                    loginIntent.putExtra("RatSighting", mRatList.get(holder.getAdapterPosition()));
                    view.getContext().startActivity(loginIntent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        LinearLayout linearLayout;

        static TextViewHolder inflate(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(list_item_text, parent, false);
            return new TextViewHolder(view);
        }

        TextViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.lit_text);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }

        void bind(String text) {
            mTextView.setText(text);
        }
    }
}
