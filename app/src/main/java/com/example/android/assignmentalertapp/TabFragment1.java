package com.example.android.assignmentalertapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Created by Montya on 17-10-2015.
 */
public class TabFragment1 extends Fragment {
    Button button1, button2, button3, button4, button5;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_1, container, false);
        button1 = (Button) v.findViewById(R.id.theory_sub_btn_1);
        button2 = (Button) v.findViewById(R.id.theory_sub_btn_2);
        button3 = (Button) v.findViewById(R.id.theory_sub_btn_3);
        button4 = (Button) v.findViewById(R.id.theory_sub_btn_4);
        button5 = (Button) v.findViewById(R.id.theory_sub_btn_5);

        DatabaseOperations DO = new DatabaseOperations(getActivity());
        Cursor cr = DO.select_table(11);
        int count = cr.getCount();
        if (count == 10) {
            button1.setText(DO.getSubjectName(0));
            button2.setText(DO.getSubjectName(1));
            button3.setText(DO.getSubjectName(2));
            button4.setText(DO.getSubjectName(3));
            button5.setText(DO.getSubjectName(4));
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 4);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SubjectPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("table", 5);
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
            button1.setText(DO.getSubjectName(0));
            button2.setText(DO.getSubjectName(1));
            button3.setText(DO.getSubjectName(2));
            button4.setText(DO.getSubjectName(3));
            button5.setText(DO.getSubjectName(4));
        }

    }


}
