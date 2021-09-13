package com.example.appnghenhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.Model.Album;
import com.example.appnghenhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

    Context context;
    ArrayList<Album> albumArrayList;

    public AlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_albumhot,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumArrayList.get(position);
        holder.txttencasi.setText(album.getTencasi());
        holder.txttenalbum.setText(album.getTenalbum());
        Picasso.with(context).load(album.getHinhalbum()).into(holder.imgalbum);
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgalbum;
        TextView txttenalbum, txttencasi;
        public ViewHolder(View itemview){
            super(itemview);
            imgalbum = itemview.findViewById(R.id.imagealbum);
            txttenalbum = itemview.findViewById(R.id.textviewtenalbum);
            txttencasi = itemview.findViewById(R.id.tencasi);
        }
    }
}
