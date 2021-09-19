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

import com.example.appnghenhac.Activity.DanhSachBaiHatActivity;
import com.example.appnghenhac.Model.Playlist;
import com.example.appnghenhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachCacPlayListAdapter extends RecyclerView.Adapter<DanhSachCacPlayListAdapter.ViewHolder>{
    Context context;
    ArrayList<Playlist> playlistArrayList;

    public DanhSachCacPlayListAdapter(Context context, ArrayList<Playlist> playlistArrayList) {
        this.context = context;
        this.playlistArrayList = playlistArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.dong_danhsachcacplaylist,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = playlistArrayList.get(position);

        Picasso.with(context).load(playlist.getHinhanh()).into(holder.hinhnen);
        holder.tenplaylist.setText(playlist.getTen());

    }

    @Override
    public int getItemCount() {
        return playlistArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hinhnen;
        TextView tenplaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhnen = itemView.findViewById(R.id.imageviewdanhsachcacplaylist);
            tenplaylist = itemView.findViewById(R.id.textviewtendanhsachplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                    intent.putExtra("itemplaylist",playlistArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
