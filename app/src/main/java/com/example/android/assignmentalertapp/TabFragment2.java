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
public class TabFragment2 extends Fragment {
    Button button6, button7, button8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);

        button6 = (Button) v.findViewById(R.id.lab_sub_btn_1);
        button7 = (Button) v.findViewById(R.id.lab_sub_btn_2);
        button8 = (Button) v.findViewById(R.id.lab_sub_btn_3);

        DatabaseOperations DO = new DatabaseOperations(getActivity());
        Cursor cr = DO.select_table(11);
        int count = cr.getCount();
        if (count == 10) {
            button6.setText(DO.getSubjectName(5));
            button7.setText(DO.getSubjectName(6));
            button8.setText(DO.getSubjectName(7));

        }

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 6);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 7);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 8);
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
            button6.setText(DO.getSubjectName(5));
            button7.setText(DO.getSubjectName(6));
            button8.setText(DO.getSubjectName(7));

        }
    }
}
