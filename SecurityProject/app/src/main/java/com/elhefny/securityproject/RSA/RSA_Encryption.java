package com.elhefny.securityproject.RSA;

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

public class RSA_Encryption extends Fragment {
    TextView decryptedMessage;
    MaterialButton encryptButton;
    TextInputEditText message;
//    int n = 33, e = 3;

    public RSA_Encryption() {
        // Required empty public constructor
    }

    public static RSA_Encryption newInstance() {
        RSA_Encryption fragment = new RSA_Encryption();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_r_s_a__encryption, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        message = view.findViewById(R.id.rsa_encryption_message);
        encryptButton = view.findViewById(R.id.rsa_encryption_btn_encrypt);
        decryptedMessage = view.findViewById(R.id.rsa_encryption_tv_cipher_message);
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (message.getText().length() > 0) {
//                    decryptedMessage.setText(Math.pow(Double.parseDouble(message.getText().toString()), e) % n + "");
                    RSA rsa=new RSA(5,11,9);
                    System.out.println(RSA.p+""+RSA.q+""+RSA.n+""+RSA.z+""+RSA.d+"");
                    decryptedMessage.setText(rsa.encrypt_Messaeg(message.getText().toString().trim().toLowerCase()));
                }else {
                    message.setError("Required");
                    message.requestFocus();
                }
            }
        });
    }
}