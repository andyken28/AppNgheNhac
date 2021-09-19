package com.example.appnghenhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.Activity.PlayNhacActivity;
import com.example.appnghenhac.Model.BaiHat;
import com.example.appnghenhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaiHatHotAdapter extends RecyclerView.Adapter<BaiHatHotAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public BaiHatHotAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihathot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat=baiHatArrayList.get(position);
        holder.txttenbaihat.setText(baiHatArrayList.get(position).getTenbaihat());
        holder.txttencasi.setText(baiHatArrayList.get(position).getCasi());
        Picasso.with(context).load(baiHatArrayList.get(position).getHinhbaihat()).into(holder.imghinhbaihat);

    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imghinhbaihat, imgluotthich;
        TextView txttenbaihat, txttencasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewbaihathot);
            txttencasi = itemView.findViewById(R.id.textviewtencasibaihathot);
            imghinhbaihat = itemView.findViewById(R.id.imageviewhinhanhbaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Picasso.with(context).load(R.drawable.iconloved).into(imgluotthich);

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",baiHatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
