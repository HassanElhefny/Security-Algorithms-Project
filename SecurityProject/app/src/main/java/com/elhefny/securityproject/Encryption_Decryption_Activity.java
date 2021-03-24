package com.elhefny.securityproject;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.elhefny.securityproject.Caser.Caser_Decryption;
import com.elhefny.securityproject.Caser.Caser_Encryption;
import com.elhefny.securityproject.Playfair.Playfair_Decryption;
import com.elhefny.securityproject.Playfair.Playfair_Encryption;
import com.elhefny.securityproject.RSA.RSA_Decryption;
import com.elhefny.securityproject.RSA.RSA_Encryption;
import com.elhefny.securityproject.Transposition.Transposition_Decryption;
import com.elhefny.securityproject.Transposition.Transposition_Encryption;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class Encryption_Decryption_Activity extends AppCompatActivity {
    FrameLayout containerLayout;
    AnimatedBottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypttion__decryption_);
        initializeViews();
        String Method = getIntent().getStringExtra(getString(R.string.send_method_name));
        bottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NotNull AnimatedBottomBar.Tab tab1) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (Method.equals(getString(R.string.method_1))) {
                    if (tab1.getId() == R.id.tab_encryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, Caser_Encryption.newInstance());
                    } else if (tab1.getId() == R.id.tab_decryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, Caser_Decryption.newInstance());
                    } else {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, MyProfile.newInstance());
                    }
                    fragmentTransaction.commit();
                } else if (Method.equals(getString(R.string.method_4))) {
                    if (tab1.getId() == R.id.tab_encryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, RSA_Encryption.newInstance());
                    } else if (tab1.getId() == R.id.tab_decryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, RSA_Decryption.newInstance());
                    } else {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, MyProfile.newInstance());
                    }
                    fragmentTransaction.commit();
                } else if (Method.equals(getString(R.string.method_2))) {
                    if (tab1.getId() == R.id.tab_encryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, Playfair_Encryption.newInstance());
                    } else if (tab1.getId() == R.id.tab_decryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, Playfair_Decryption.newInstance());
                    } else {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, MyProfile.newInstance());
                    }
                    fragmentTransaction.commit();
                } else if (Method.equals(getString(R.string.method_3))) {
                    if (tab1.getId() == R.id.tab_encryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, Transposition_Encryption.newInstance());
                    } else if (tab1.getId() == R.id.tab_decryption) {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, Transposition_Decryption.newInstance());
                    } else {
                        fragmentTransaction.replace(R.id.encryption_decryption_container, MyProfile.newInstance());
                    }
                    fragmentTransaction.commit();
                }

            }

            @Override
            public void onTabReselected(int i, @NotNull AnimatedBottomBar.Tab tab) {
            }
        });

        bottomBar.createTab(R.drawable.ic_encrypted, "Encryption", R.id.tab_encryption);
        bottomBar.createTab(R.drawable.ic_decryption, "Decryption", R.id.tab_decryption);
        bottomBar.createTab(R.drawable.ic_decryption, "My Profile", R.id.tab_profile);
        bottomBar.selectTabById(R.id.tab_encryption, true);
    }

    private void initializeViews() {
        bottomBar = findViewById(R.id.bottom_bar);
        containerLayout = findViewById(R.id.encryption_decryption_container);
    }
}