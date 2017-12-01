package com.mobile_final.friendorfoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mobile_final.friendorfoe.database.DataSource;

public class Start_Up extends AppCompatActivity implements View.OnClickListener{
    DataSource mDataSource;
    ConstraintLayout cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__up);
        findViewById(R.id.Start_Gme).setOnClickListener(this);
        findViewById(R.id.How_To_Play).setOnClickListener(this);
        findViewById(R.id.Credits).setOnClickListener(this);
        cc = (ConstraintLayout) findViewById(R.id.laylay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mDataSource.open();
    }
    private void toastMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Start_Gme:
                StartGame(view);
                break;
            case R.id.How_To_Play:
                ShowHelp(view);
                break;
            case R.id.Credits:
               Credits(view);
                break;
            default:
                break;
        }
    }
    public void StartGame(View view)
    {
        Intent intent = new Intent(this, gamelogic.class);
        startActivity(intent);
    }
    public void ShowHelp(View view)
    {
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }
    public void Credits(View view)
    {
        Intent intent = new Intent(this, gamelogic.class);
        startActivity(intent);
    }
}

