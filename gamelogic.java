package com.mobile_final.friendorfoe;

import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.mobile_final.friendorfoe.database.DataSource;
import com.mobile_final.friendorfoe.model.DataStudent;

import java.util.UUID;

public class gamelogic extends AppCompatActivity {

    public Button btn;
    DataSource mDataSource;
    private EditText Name;
    private EditText Phone;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        btn = (Button) findViewById(R.id.angry_btn);
        Name = (EditText) findViewById(R.id.nameText);
        Phone = (EditText) findViewById(R.id.phone);

        //Databse
        try {
            mDataSource = new DataSource(this);
            mDataSource.open();
            loadData();
            toastMessage("Database Created");
        } catch (SQLiteException e) {
            toastMessage(e.toString());
            e.printStackTrace();
        }

        final TabHost host = (TabHost) findViewById(R.id.TabHostj);
        host.setup();
        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Add Plyer");
        spec.setContent(R.id.AddPlayers);
        spec.setIndicator("Add Player");
        host.addTab(spec);
        //Tab 2
        spec = host.newTabSpec("View Players");
        spec.setContent(R.id.ViewPlayers);
        spec.setIndicator("View Players");
        host.addTab(spec);

        btn.setOnClickListener(new View.OnClickListener() {
            DataStudent mike = new DataStudent();
            @Override
            public void onClick(View v) {
                mike.setID(UUID.randomUUID().toString());
                mike.setName(Name.getText().toString());
                mike.setstudentPhone(Phone.getText().toString());

                if (Name.length() != 0 && Phone.length() != 0)
                {
                        mDataSource.createStudent(mike);
                        loadData();
                        host.setCurrentTab(1);
                } else {
                    toastMessage("You must enter data in ALL text fields or Take Picture!!");
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }

    private void toastMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }

    public void onFragmentInteraction(Uri uri)
    {

    }

    public void loadData(){
        try {
            FragmentManager FragMan = getSupportFragmentManager();
            ((LinearLayout) findViewById(R.id.ViewPlayers)).removeAllViews();
            FragmentTransaction FragTran = FragMan.beginTransaction();
            for(final DataStudent s: mDataSource.getAll())
            {
                final PlayerFragment SF =  PlayerFragment.newInstance(s);
                final gamelogic ActivityMe = this;
                FragTran.add(R.id.ViewPlayers, SF, s.hashCode()+s.getName());
            }
            FragTran.commit();
        }
        catch(Exception e)
        {
            String s = e.getMessage();
            s = s;
        }
    }
}

