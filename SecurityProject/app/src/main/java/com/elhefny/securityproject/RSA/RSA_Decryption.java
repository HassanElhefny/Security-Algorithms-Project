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

import java.math.BigDecimal;
import java.math.BigInteger;

public class RSA_Decryption extends Fragment {
    MaterialButton decryptionButton;
    TextInputEditText cipherMessage;
    TextView originalMessage;
//    int p = 3, q = 11, n = p * q, e = 3, d = modInverse(e, (p-1)*(q-1));

    public RSA_Decryption() {
        // Required empty public constructor
    }

    public static RSA_Decryption newInstance() {
        RSA_Decryption fragment = new RSA_Decryption();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_r_s_a__decryption, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        originalMessage = view.findViewById(R.id.rsa_decryption_tv_original_message);
        cipherMessage = view.findViewById(R.id.rsa_decryption_cipher_message);
        decryptionButton = view.findViewById(R.id.rsa_decryption_btn_decrypt);
        decryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cipherMessage.getText().length() > 0) {
//                    //converting int value of n to BigInteger
//                    BigInteger N = BigInteger.valueOf(n);
//                    //converting float value of c to BigInteger
//                    BigInteger C = BigDecimal.valueOf(Double.parseDouble(cipherMessage.getText().toString())).toBigInteger();
                    //                    originalMessage.setText((C.pow(d)).mod(N) + "");

                    RSA rsa = new RSA(5,11,9);
                    System.out.println(RSA.p+""+RSA.q+""+RSA.n+""+RSA.z+""+RSA.d+"");
                    String cipherText = rsa.decrypt_Messaeg(cipherMessage.getText().toString().trim().toLowerCase());
                    originalMessage.setText(cipherText);
                } else {
                    cipherMessage.setError("Required");
                    cipherMessage.requestFocus();
                }
            }
        });
    }


}