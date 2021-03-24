package com.elhefny.securityproject.Caser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elhefny.securityproject.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Caser_Encryption extends Fragment {
    TextInputEditText key, message;
    MaterialButton encryptButton;
    TextView DecryptMessage;

    public Caser_Encryption() {
        // Required empty public constructor
    }

    public static Caser_Encryption newInstance() {
        Caser_Encryption fragment = new Caser_Encryption();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caser__encryption, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        key = view.findViewById(R.id.caser_fragment_encryption_key);
        message = view.findViewById(R.id.caser_fragment_encryption_text);
        encryptButton = view.findViewById(R.id.caser_fragment_encryption_btn_encrypt);
        DecryptMessage = view.findViewById(R.id.caser_fragment_encryption_tv_decrypted_message);
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.getText().length() == 0) {
                    key.setError("Key Is Required Required");
                    key.requestFocus();
                } else if (message.getText().length() == 0) {
                    message.setError("Message Is Required");
                    message.requestFocus();
                } else {
                    DecryptMessage.setText(encrypt(message.getText().toString().trim(), Integer.parseInt(key.getText().toString().trim())).toString());
                }
            }
        });
    }

    // Encrypts text using a shift od s
    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}