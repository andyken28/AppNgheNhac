package com.example.appnghenhac.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnghenhac.Model.ChuDeVaTheLoai;
import com.example.appnghenhac.R;
import com.example.appnghenhac.Service.APIService;
import com.example.appnghenhac.Service.Dataservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai_ToDay extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthemchudetheloai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai,container,false);
//        horizontalScrollView = view.findViewById(R.id.horizontalscrollview);
//        txtxemthemchudetheloai = view.findViewById(R.id.textviewxemthe);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDeVaTheLoai>> callback = dataservice.GetDataChuDeTheLoaiToDay();
        callback.enqueue(new Callback<List<ChuDeVaTheLoai>>() {
            @Override
            public void onResponse(Call<List<ChuDeVaTheLoai>> call, Response<List<ChuDeVaTheLoai>> response) {
                ChuDeVaTheLoai theloaitrongngay = (ChuDeVaTheLoai) response.body();
//                Log.d("FFF",theloaitrongngay.getTheLoai().get(0).getTentheloai());
//                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
//                chuDeArrayList.addAll(theloaitrongngay.getChuDe());
//
//                final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
//                theLoaiArrayList.addAll(theloaitrongngay.getTheLoai());

                /*
                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(580,250);
                layoutParams.setMargins(10,20,10,30);


                for(int i=0; i<chuDeArrayList.size(); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(8);
                    ImageView imageView =new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(chuDeArrayList.get(i).getHinhchude() != null){
                        Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhchude()).into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                for(int j=0; j<theLoaiArrayList.size(); j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(8);
                    ImageView imageView =new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(theLoaiArrayList.get(j).getHinhtheloai() != null){
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(j).getHinhtheloai()).into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);

                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);*/
            }

            @Override
            public void onFailure(Call<List<ChuDeVaTheLoai>> call, Throwable t) {

            }
        });
    }

}
