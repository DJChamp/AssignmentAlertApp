package com.example.android.assignmentalertapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Scanner;

/**
 * Created by Montya on 17-10-2015.
 */
public class TabFragment3 extends Fragment {
    Button button9, button10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_3, container, false);
        button9 = (Button) v.findViewById(R.id.tutorial_sub_btn_1);
        button10 = (Button) v.findViewById(R.id.tutorial_sub_btn_2);

        DatabaseOperations DO = new DatabaseOperations(getActivity());
        Cursor cr = DO.select_table(11);
        int count = cr.getCount();
        if (count == 10) {
            button9.setText(DO.getSubjectName(8));
            button10.setText(DO.getSubjectName(9));
        }

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 9);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 10);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        DatabaseOperations DO = new DatabaseOperations(getActivity());
        Cursor cr = DO.select_table(11);
        int count = cr.getCount();
        if (count == 10) {
            button9.setText(DO.getSubjectName(8));
            button10.setText(DO.getSubjectName(9));
        }
    }
}
