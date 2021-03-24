package com.elhefny.securityproject.Transposition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elhefny.securityproject.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class Transposition_Encryption extends Fragment {
    MaterialTextView cipherMessage;
    MaterialButton btnEncrypt;
    TextInputEditText key, originalMessage;
    TranspositionCipher transpositionCipher;

    public Transposition_Encryption() {
        // Required empty public constructor
    }

    public static Transposition_Encryption newInstance() {
        Transposition_Encryption fragment = new Transposition_Encryption();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transposition__encryption, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        originalMessage = view.findViewById(R.id.transposition_encryption_original_message);
        cipherMessage = view.findViewById(R.id.transposition_encryption_cipher_message);
        key = view.findViewById(R.id.transposition_encryption_key);
        btnEncrypt = view.findViewById(R.id.transposition_encryption_btn_encrypt);
        btnEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.getText().length() == 0) {
                    key.setError("Required");
                    key.requestFocus();
                } else if (originalMessage.getText().length() == 0) {
                    originalMessage.setError("Required");
                    originalMessage.requestFocus();
                } else {
                    transpositionCipher = new TranspositionCipher(key.getText().toString().trim().toUpperCase());
                    cipherMessage.setText(transpositionCipher.doEncryption(originalMessage.getText().toString().trim()));
                }
            }
        });
    }
}