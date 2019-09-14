package com.example.android.assignmentalertapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Montya on 22-10-2015.
 */
public class SubjectPage extends AppCompatActivity {
    Button btn;
    ListView LIST;
    TextView listTitle;
    int table;
    DatabaseOperations DB;
    ArrayList array_list;

    ArrayAdapter<String> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_page_layout);
        btn = (Button) findViewById(R.id.add_new_btn);
        LIST = (ListView) findViewById(R.id.list);
        listTitle = (TextView) findViewById(R.id.list_title);
        final Context ctx = this;

        Bundle extras = getIntent().getExtras();
        table = extras.getInt("table");
        registerForContextMenu(LIST);   //creates a pop up menu

        DB = new DatabaseOperations(this);

        listTitle.setText(DB.getSubjectName(table - 1));
        array_list = DB.getAllTitles(table);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_list);
        LIST.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ctx, AddEntry.class);
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("button", table);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });

        LIST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int id_To_Search = i;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);
                dataBundle.putInt("table", table);

                Intent intent = new Intent(getApplicationContext(), DisplayAssignment.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        Intent i = getIntent();
        startActivity(i);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() != R.id.list) {
            return;
        }
        menu.setHeaderTitle("What would you like to do?");  //setting the heading of pop up menu

        String[] options = {"Delete", "Back"};

        for (String option : options)      //adding "delete"   and   "Back" to the context menu
        {
            menu.add(option);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {              //called when a item in pop up menu is selected
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();//gets info of the item of the array list
        int selectedIndex = info.position;       //returns index of the item of arraylist

        if (item.getTitle().equals("Delete")) {
            DB.deleteAssignment(DB.getTitle(selectedIndex, table), DB.getAssignmentInfo(selectedIndex, table), table);
            array_list.remove(selectedIndex);
            arrayAdapter.notifyDataSetChanged();    //re_shuffel the adapter
        }
        return true;
    }

}
