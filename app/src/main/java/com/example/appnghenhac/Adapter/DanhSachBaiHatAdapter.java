package com.example.appnghenhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.Model.BaiHat;
import com.example.appnghenhac.R;

import java.util.ArrayList;

public class DanhSachBaiHatAdapter extends RecyclerView.Adapter<DanhSachBaiHatAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public DanhSachBaiHatAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachbaihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        BaiHat baiHat = new BaiHat();
//        baiHat = baiHatArrayList.get(position);
        holder.txtindex.setText(position+1+"");
        if(baiHatArrayList.get(position).getTenbaihat()!=null)
            holder.txttenbaihat.setText(baiHatArrayList.get(position).getTenbaihat());
        if(baiHatArrayList.get(position).getCasi()!=null)
            holder.txtcasi.setText(baiHatArrayList.get(position).getCasi());

    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtindex, txttenbaihat, txtcasi;
        ImageView imgluotthich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihatdanhsach);
            txtcasi = itemView.findViewById(R.id.textviewcasidanhsach);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);
        }
    }
}
