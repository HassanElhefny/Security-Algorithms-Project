package com.elhefny.securityproject.RSA;

public class RSA {
    public static int p, q, e, n, d, z;

    public RSA(int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.e = e;
        n = calculate_n(p, q);
        d = calculate_D(e);
        z = calculate_z(p, q);
    }

    private static int calculate_z(int P, int Q) {
        return (P - 1) * (Q - 1);
    }

    private static int calculate_n(int P, int Q) {
        return P * Q;
    }

    private static int calculate_D(int E) {
        return modInverse(E, calculate_z(p, q));
    }

    //------------------------------------------------------------
    //modular Inverse
    private static int modInverse(int a, int m) {

        for (int x = 1; x < m; x++)
            if (((a % m) * (x % m)) % m == 1)
                return x;
        return 1;
    }

    public static String encrypt_Messaeg(String text) {
        String encrypt = "";
        long c, p, num;
        char t;

        for (int i = 0; i < text.length(); ++i) {
            t = text.charAt(i);
            t = Character.toLowerCase(t);
            p = t - 97;
            num = (long) Math.pow(p, e);
            c = mod(String.valueOf(num), n);
            encrypt += text.charAt(i) + ":" + String.valueOf(c) + "  ";
        }
        return encrypt;
    }

    public static String decrypt_Messaeg(String cipher) {


        String decrypt = "", c;
        String[] splited = cipher.split(" ");
        long D, num;
        char t;

        for (int i = 0; i < splited.length; ++i) {
            c = splited[i];
            num = (long) Math.pow(Long.valueOf(c), d);
            D = mod(String.valueOf(num), n);
            decrypt += c + ":" + (char) (D + 97) + "  ";
        }

        return decrypt;
    }


    private static int mod(String num, int a) {

        int res = 0;
        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int) num.charAt(i) - '0') % a;

        return res;
    }
}
