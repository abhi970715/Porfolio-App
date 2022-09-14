package com.example.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myfirstapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_DETAILS_CODE=1337;
    public static  final String tag="MainActivity";
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
     private String gitHunUserName=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FloatingActionButton addDetails=findViewById(R.id.fab);
        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,first.class);
                startActivityForResult(intent,REQUEST_DETAILS_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_DETAILS_CODE && resultCode==RESULT_OK && data!=null){
            PortFolio portfolio=data.getParcelableExtra(first.PARAM_PORTFOLIO);
            if(portfolio!=null)
                setDetails(portfolio);
        }
    }
    public void setDetails(PortFolio portfolio){
        TextView textViewName=findViewById(R.id.name);
        TextView textViewPos=findViewById(R.id.title);
//        TextView textViewEdLabel=findViewById(R.id.education_label);
        TextView textViewEdDegree=findViewById(R.id.education_degree);
        TextView textViewEdTitle=findViewById(R.id.education_title);
        TextView textViewEdYear=findViewById(R.id.education_year);
        TextView textViewCoDegree=findViewById(R.id.course_degree);
//        TextView textViewCoLabel=findViewById(R.id.course_label);
        TextView textViewCoTitle=findViewById(R.id.course_title);
        TextView textViewCoYear=findViewById(R.id.course_year);


        textViewName.setText(portfolio.getName());
        textViewPos.setText(portfolio.getPosition());
        textViewEdDegree.setText(portfolio.getEducation().getDegree());
        textViewEdTitle.setText(portfolio.getEducation().getName());
        textViewEdYear.setText(portfolio.getEducation().getYear());
        textViewCoTitle.setText(portfolio.getCourse().getOrg());
        textViewCoDegree.setText(portfolio.getCourse().getDegree());
        textViewCoYear.setText(portfolio.getCourse().getYear());


        gitHunUserName=portfolio.getGitHubUserName();

    }

    public void openGitHub(View view) {
        String githubUrl="https://github.com/";
        if(gitHunUserName!=null){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl+gitHunUserName));
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this,"Not a Valid GitHUB User Name",Toast.LENGTH_SHORT).show();
        }
    }
}