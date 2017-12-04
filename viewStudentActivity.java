package com.mobile_final.friendorfoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mobile_final.friendorfoe.database.DataSource;
import com.mobile_final.friendorfoe.model.DataStudent;

import java.util.List;

public class viewStudentActivity extends AppCompatActivity {
    DataSource mDataSource;
    DataStudent DS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_student);
            String ID = getIntent().getStringExtra("StudentID");

            mDataSource = new DataSource(this);
            mDataSource.open();
            List<DataStudent> Dlist = mDataSource.getAll();
            for(DataStudent s : Dlist)
            {
                if(ID.equals(s.getID()))
                {
                    DS = s;
                    break;
                }
            }
            ((TextView) findViewById(R.id.name)).setText(DS.getName());
            ((TextView) findViewById(R.id.phoneNum)).setText(DS.getstudentPhone());
//            ((TextView) findViewById(R.id.spinnerOS)).setText(DS.getOS());
        }
        catch (Exception e)
        {
            String s = e.getMessage();
            s = s;
        }
    }

}