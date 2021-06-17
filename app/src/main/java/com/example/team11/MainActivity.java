package com.example.team11;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    public ArrayAdapter adapter1, adapter2, adapter3, adapter4;
    Button submit;
    ArrayList<String> selected = new ArrayList<>();
    ListView listView1, listView2, listView3, listView4;
    String[] teamIndia = new String[]{"Rohit Sharma","Shikar Dhawan","Virat Kohli",
            "Rishabh Pant","Shreyas Iyer","Mahendra Singh Dhoni", "Ravindra Jadeja","Y Chahal",
            "M Shami","Jaspreet Bumrah"};

    String[] teamAus =new String[]{"Steve Smith","Aaron Finch","Davide Warner","Glenn Maxwell","Mitchell Starc",
            "Marcus Stonis","Pat Cummins","Adam Zampa","Alex Carey","Nathan Lyon","Ashton Agar"};

    String[] teamEng = new String[]{"Ben Stokes","Joe Root","Jofra Archer","Jos Buttler",
            "Eoin Morgan","Jason Roy","Jonny Bairstow","Chris Woakes","Moeen Ali",
            "Tom Curran","Sam Curran",};

    String[] teamSA = new String[]{"Faf Du Plessis","Quinton de Kock","Kasigo Rabada","Lungi Ngidi",
            "Davide Miller","Imran Tahir","Chris Morris","JP Duminy","Tabraiz Shamsi","Beuran Hendricks","Dwaine Pretoris"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, teamIndia);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, teamAus);
        adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, teamEng);
        adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, teamSA);

        listView1 = findViewById(R.id.indianTeam);
        listView2 = findViewById(R.id.ausTeam);
        listView3 = findViewById(R.id.engTeam);
        listView4 = findViewById(R.id.saTeam);
        submit = findViewById(R.id.done);

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
        listView3.setAdapter(adapter3);
        listView4.setAdapter(adapter4);

        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView3.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView4.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView1.setOnItemClickListener(this);
        listView2.setOnItemClickListener(this);
        listView3.setOnItemClickListener(this);
        listView4.setOnItemClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

        String item = (String) parent.getItemAtPosition(i);
        //view.setBackgroundColor(Color.WHITE);
        
        if(selected.size() == 11){
            Toast.makeText(this,"More than 11 members are selected",Toast.LENGTH_SHORT).show();
        }
        else{
            if(selected.contains(item)) {
                //iew.setBackgroundColor(Color.TRANSPARENT);
                selected.remove(item);
            }
            else
                selected.add(item);
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,"Team",Toast.LENGTH_SHORT).show();
        if(selected.size() == 11){
            Toast.makeText(this,"Final Team",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            i.putStringArrayListExtra("Team",selected);
            startActivity(i);
        }
        else
            Toast.makeText(this,"11 players not selected",Toast.LENGTH_SHORT).show();
    }
}