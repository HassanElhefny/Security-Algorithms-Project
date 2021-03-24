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

public class Transposition_Decryption extends Fragment {
    MaterialTextView originalMessage;
    MaterialButton btnDecrypt;
    TextInputEditText key, cipherMessage;
    TranspositionCipher transpositionCipher;

    public Transposition_Decryption() {
        // Required empty public constructor
    }

    public static Transposition_Decryption newInstance() {
        Transposition_Decryption fragment = new Transposition_Decryption();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transposition__decryption, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        originalMessage = view.findViewById(R.id.transposition_decryption_original_message);
        cipherMessage = view.findViewById(R.id.transposition_decryption_cipher_message);
        key = view.findViewById(R.id.transposition_decryption_key);
        btnDecrypt = view.findViewById(R.id.transposition_decryption_btn_decrypt);
        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.getText().length() == 0) {
                    key.setError("Required");
                    key.requestFocus();
                } else if (cipherMessage.getText().length() == 0) {
                    cipherMessage.setError("Required");
                    cipherMessage.requestFocus();
                } else {
                    transpositionCipher = new TranspositionCipher(key.getText().toString().trim().toUpperCase());
                    originalMessage.setText(transpositionCipher.doDecryption(cipherMessage.getText().toString().trim()));
                }
            }
        });
    }
}