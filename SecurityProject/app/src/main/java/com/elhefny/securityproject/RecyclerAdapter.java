package com.elhefny.securityproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.securityHolder> {
    Context context;
    ArrayList<MethodItemDetail> securityMethodsItems;
    itemClick listener;

    public RecyclerAdapter(Context context, ArrayList<MethodItemDetail> securityMethodsItems, itemClick listener) {
        this.context = context;
        this.securityMethodsItems = securityMethodsItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public securityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_element_design, parent, false);
        return new securityHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull securityHolder holder, int position) {
        MethodItemDetail currItemDetail = securityMethodsItems.get(position);
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.item_fall_down));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.getItemClick(currItemDetail.getMethodName());
            }
        });
        holder.tv_title.setText(currItemDetail.getMethodName());
        holder.tv_description.setText(currItemDetail.getMethodDescription());
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(currItemDetail.getMethodName().substring(0, 1)
                        .toUpperCase(), color);
        holder.iv.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return securityMethodsItems.isEmpty() ? 0 : securityMethodsItems.size();
    }

    public class securityHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_title, tv_description;

        public securityHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.recycler_element_design_iv);
            tv_title = itemView.findViewById(R.id.recycler_element_design_tv_title);
            tv_description = itemView.findViewById(R.id.recycler_element_design_tv_description);
        }
    }

    interface itemClick {
        void getItemClick(String MethodName);
    }
}
