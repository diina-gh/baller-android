package com.example.baller.ui.teams;

import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.baller.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamsFragment extends ListFragment {

    private TeamsViewModel mViewModel;
    public static TeamsFragment newInstance() {
        return new TeamsFragment();
    }

   // Array of strings storing country names
    String[] countries = new String[] {
            "AS Douanes",
            "Diambars",
            "Génération Foot",
            "Teungueth FC",
            "AS Pikine",
            "CNEPS Excellence",
            "Jaraaf",
            "Stade de Mbour",
            "Casa Sports",
            "Dakar Sacré Coeur",
           "Ndiambour",
           "Mbour PC",
           "US Gorée",
           "Niarry Tally"
    };

    // Array of integers points to images stored in /res/drawable/
    int[] flags = new int[]{
            R.drawable.douane,
            R.drawable.diambars,
            R.drawable.generation,
            R.drawable.teungueth,
            R.drawable.pikine,
            R.drawable.excellence,
            R.drawable.jaraaf,
            R.drawable.stadedembour,
            R.drawable.casa,
            R.drawable.sacrecoeur,
            R.drawable.ndiambour,
            R.drawable.mbour,
            R.drawable.goree,
            R.drawable.niarytally

    };

    // Array of strings to store currencies
    String[] currency = new String[]{
            "6",
            "10",
            "2",
            "5",
            "8",
            "1",
            "10",
            "1",
            "1",
            "3",
            "5",
            "1",
            "1",
            "1",
    };


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.teams_fragment, container, false);
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<14;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", (i+1) + ".  " + countries[i]);
            hm.put("cur","Trophées : " + currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};

        // Instantiating an adapter to store each items
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.teams_fragment, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TeamsViewModel.class);
        // TODO: Use the ViewModel
    }

}