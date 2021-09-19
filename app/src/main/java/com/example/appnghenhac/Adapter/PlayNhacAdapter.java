package com.example.appnghenhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.Model.BaiHat;
import com.example.appnghenhac.R;

import java.util.ArrayList;

public class PlayNhacAdapter extends RecyclerView.Adapter<PlayNhacAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public PlayNhacAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_playbaihat,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = baiHatArrayList.get(position);
        holder.txtindex.setText(1+position + "");
        holder.txttenbaihat.setText(baiHat.getTenbaihat());
        holder.txtcasi.setText(baiHat.getCasi());
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenbaihat, txtcasi, txtindex;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtindex  = itemView.findViewById(R.id.textviewindexplaybaihat);
            txttenbaihat  = itemView.findViewById(R.id.textviewtenplaybaihat);
            txtcasi  = itemView.findViewById(R.id.textviewtencasiplaybaihat);
        }
    }
}
