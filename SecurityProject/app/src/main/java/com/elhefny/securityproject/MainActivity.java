package com.elhefny.securityproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_security_methods;
    RecyclerAdapter Adapter;
    ArrayList<MethodItemDetail> securityMethods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeViews();
        buildAdapter();
    } 

    private void buildAdapter() {
        addSecurityMethods();
        Adapter = new RecyclerAdapter(this, securityMethods, new RecyclerAdapter.itemClick() {
            @Override
            public void getItemClick(String MethodName) {
                Intent i = new Intent(MainActivity.this, Encryption_Decryption_Activity.class);
                i.putExtra(getString(R.string.send_method_name), MethodName);
                i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });
        rv_security_methods.setAdapter(Adapter);
        rv_security_methods.setHasFixedSize(true);
        rv_security_methods.setLayoutManager(new LinearLayoutManager(this));
        setLayoutAnimation();
    }

    private void addSecurityMethods() {
        MethodItemDetail caser = new MethodItemDetail(getString(R.string.method_1), getString(R.string.method_1_description));
        securityMethods.add(caser);
        MethodItemDetail playfair = new MethodItemDetail(getString(R.string.method_2), getString(R.string.method_2_description));
        securityMethods.add(playfair);
        MethodItemDetail transposition = new MethodItemDetail(getString(R.string.method_3), getString(R.string.method_3_description));
        securityMethods.add(transposition);
        MethodItemDetail rsa = new MethodItemDetail(getString(R.string.method_4), getString(R.string.method_4_description));
        securityMethods.add(rsa);
    }

    private void InitializeViews() {
        rv_security_methods = findViewById(R.id.main_activity_rv_security_methods);
        securityMethods = new ArrayList<>();
    }

    private void setLayoutAnimation() {
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(rv_security_methods.getContext(), R.anim.layout_fall_down);
        rv_security_methods.setLayoutAnimation(controller);
        rv_security_methods.getAdapter().notifyDataSetChanged();
        rv_security_methods.scheduleLayoutAnimation();
    }
}