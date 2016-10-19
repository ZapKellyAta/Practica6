package com.example.kellyjohanazapataestrada.practica6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kellyjohanazapataestrada.practica6.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostresFragment extends Fragment {


    public PostresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_postres, container, false);
        return view;
    }

}
