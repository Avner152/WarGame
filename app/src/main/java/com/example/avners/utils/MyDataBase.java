package com.example.avners.utils;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MyDataBase {
    private ArrayList<Record> records;
    private final int MAX_SIZE = 10;

    public MyDataBase(){
        records = new ArrayList<Record>();
    }
    public Boolean insert_Record(Record record){
        if(records.size() >= MAX_SIZE)
            for (int i = MAX_SIZE; i < records.size(); i++) {
                records.remove(i);
            }
        if (records.size() == 0){
            records.add(record);
            return true;
        }

        if (records.size() < MAX_SIZE) {
            records.add(record);
        }
        else {
            findRecordToDump(record);
        }
        sortDsc();
        return true;
    }

    private void sortDsc() {
        Collections.sort(records, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o2.getScore() - o1.getScore();
            }
        });
    }

    public void findRecordToDump(Record r) {
        Stack<Record> temp = new Stack<>();
        records.add(r);
        int count = 2;
        sortDsc();
        for (int i = MAX_SIZE; i >= 0 ; i--) {
            temp.push(records.get(i));
        }
        records.clear();

        while(count >= 0) {
            records.add(temp.pop());
            count--;
        }
        temp.clear();
    }

    public ArrayList<Record> getRecords() {
        return records;
    }
}
