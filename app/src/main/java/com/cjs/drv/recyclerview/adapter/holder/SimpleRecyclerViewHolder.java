package com.cjs.drv.recyclerview.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.cjs.drv.R;


public class SimpleRecyclerViewHolder extends ViewHolder {
    public ImageView iconView;
    public TextView textView;

    public SimpleRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        iconView = itemView.findViewById(R.id.icon);
        textView = itemView.findViewById(R.id.tv);
    }
}
