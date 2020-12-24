package com.example.avners.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.avners.R;
import com.example.avners.utils.MyDataBase;
import com.example.avners.utils.mySPV;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Fragment_list extends Fragment {

    private Button btn;
    private CallBack_list callBackList;
    private ListView score_list;
    private String fromJson;
    private ArrayList<String> topThree;

    private Gson gson;
    private MyDataBase dataBase;
//    findViews();
//    initViews()

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);
        findView(v);
        String str = "sd";
        Bundle bundle = getArguments();
        //initiate variables
        topThree = new ArrayList<>();
        gson = new Gson();

        fromJson = mySPV.getInstance().getString("myKey","");
        if(fromJson != ""){
            dataBase = gson.fromJson(fromJson, MyDataBase.class);}
        if(dataBase !=  null) {
            for (int i = 0; i < dataBase.getRecords().size(); i++) {
                topThree.add(dataBase.getRecords().get(i).toString());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, topThree);
        score_list.setAdapter(adapter);

        if(bundle != null) {
             str = (String) bundle.get("My_String");
        }
            Log.d("TAG", "onCreateView: " + str);
        //        btn = v.findViewById(R.id.score_BTN_push);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            if(cbl != null)
//                cbl.onScoreSampleListener(10.24444, 20.33555);
//            }
//        });

        return v;
    }

    private void findView(View v) {
        score_list = v.findViewById(R.id.score_list);

    }

    public interface CallBack_list{
        void onScoreSampleListener(double d1, double d2);
        void addWinnerToList(String str);
    }

    public void setCallBackList(CallBack_list callBackList) {
        this.callBackList = callBackList;
    }
}

