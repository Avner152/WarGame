package com.example.avners.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.avners.R;
import com.example.avners.utils.MyDataBase;
import com.example.avners.utils.MySPV;
import com.example.avners.utils.Record;
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
        Bundle bundle = getArguments();
        //initiate variables
        topThree = new ArrayList<>();
        gson = new Gson();

        fromJson = MySPV.getInstance().getString("myKey","");
        if(fromJson != ""){
            dataBase = gson.fromJson(fromJson, MyDataBase.class);}
        if(dataBase !=  null) {
            Log.d("DATA BASE SIZE ARRAY", "" + dataBase.getRecords().size());
            for (int i = 0; i < dataBase.getRecords().size(); i++) {
                if(i == 0)
                    topThree.add("The Champion: " + dataBase.getRecords().get(i).toString());
                else if(i == 1)
                    topThree.add("2nd place: " + dataBase.getRecords().get(i).toString());
                else if(i == 2)
                    topThree.add("3rd place: " + dataBase.getRecords().get(i).toString());
                else
                    topThree.add((i+1) +"th place:" + dataBase.getRecords().get(i).toString());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, topThree);
        score_list.setAdapter(adapter);

        initViews();
        return v;
    }

    private void initViews() {
        score_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callBackList.onScoreSampleListener(dataBase.getRecords().get(position).getLon(),
                        dataBase.getRecords().get(position).getLat());
            }
        });
    }

    private void findView(View v) {
        score_list = v.findViewById(R.id.score_list);
    }


    public interface CallBack_list{
        void onScoreSampleListener(double d1, double d2);
    }

    public void setCallBackList(CallBack_list callBackList) {
        this.callBackList = callBackList;
    }
}