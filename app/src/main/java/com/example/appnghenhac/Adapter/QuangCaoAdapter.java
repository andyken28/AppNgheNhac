package com.example.appnghenhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appnghenhac.Model.QuangCao;
import com.example.appnghenhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QuangCaoAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> quangCaoArrayList;

    public QuangCaoAdapter(Context context, ArrayList<QuangCao> quangCaoArrayList) {
        this.context = context;
        this.quangCaoArrayList = quangCaoArrayList;
    }

    @Override
    public int getCount() {
        return quangCaoArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_quangcao,null);
        ImageView imgsongquangcao = view.findViewById(R.id.imageviewquangcao);
        ImageView imgbackground = view.findViewById(R.id.imageviewbackgroundquangcao);
        TextView txttitlebaihatquangcao = view.findViewById(R.id.textviewtitlequangcaobaihat);
        TextView txtnoidungquangcao = view.findViewById(R.id.textviewnoidungquangcao);

        Picasso.with(context).load(quangCaoArrayList.get(position).getHinhAnh()).into(imgbackground);
        Picasso.with(context).load(quangCaoArrayList.get(position).getHinhBaiHat()).into(imgsongquangcao);
        txttitlebaihatquangcao.setText(quangCaoArrayList.get(position).getTenBaiHat());
        txtnoidungquangcao.setText(quangCaoArrayList.get(position).getNoiDung());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
