package com.project.autopool;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Menu1 extends Fragment {

    ProgressDialog progressDialog;


    private Button btbook;
    private Spinner spinner_src, spinner_destination;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View rootView = inflater.inflate(R.layout.fragment_menu_1, container, false);
        btbook = (Button) (rootView).findViewById(R.id.btbook);
        spinner_src = (rootView).findViewById(R.id.spinner_src);
        spinner_destination = (rootView).findViewById(R.id.spinner_destination);

        spinner_src.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, Settings.locations));
        spinner_destination.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, Settings.locations));

        btbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookAutoActivity.class);
                intent.putExtra("src", spinner_src.getSelectedItem().toString());
                intent.putExtra("dest", spinner_destination.getSelectedItem().toString());
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    void show_toast(String msg) {
        Toast.makeText(getActivity(), "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Book Ride");
    }


}

