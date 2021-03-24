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

public class Caser_Decryption extends Fragment {
    TextInputEditText key, encryptedMessage;
    MaterialButton decryptButton;
    TextView EncryptMessage;

    public Caser_Decryption() {
        // Required empty public constructor
    }

    public static Caser_Decryption newInstance() {
        Caser_Decryption fragment = new Caser_Decryption();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caser__decryption, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        key = view.findViewById(R.id.caser_fragment_decryption_key);
        encryptedMessage = view.findViewById(R.id.caser_fragment_decryption_text);
        decryptButton = view.findViewById(R.id.caser_fragment_decryption_btn);
        EncryptMessage = view.findViewById(R.id.caser_fragment_decryption_tv_encrypted_message);
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.getText().length() == 0) {
                    key.setError("Key Is Required Required");
                    key.requestFocus();
                } else if (encryptedMessage.getText().length() == 0) {
                    encryptedMessage.setError("Message Is Required");
                    encryptedMessage.requestFocus();
                } else {
                    EncryptMessage.setText(decrypt(encryptedMessage.getText().toString().trim(), 26 - Integer.parseInt(key.getText().toString().trim())).toString());
                }
            }
        });
    }

    // Decrypts cipher using shift
    public static StringBuffer decrypt(String cipher, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }


}