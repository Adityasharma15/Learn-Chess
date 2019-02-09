package com.example.aditya.learnchess;


import android.R.layout;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.layout.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {


    public ListFrag() {
        // Required empty public constructor
    }

    //just like declaring
    ItemSelected activity;

    public interface ItemSelected
    {
        // create a method .. onitemselected is just a name
        void OnItemSelected(int index);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);

            String [] data = getResources().getStringArray(R.array.pieces);

            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        activity.OnItemSelected(position);
    }
}
