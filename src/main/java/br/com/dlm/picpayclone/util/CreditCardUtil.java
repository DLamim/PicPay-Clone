package br.com.dlm.picpayclone.util;

public class CreditCardUtil {

    public static String mask(String number) {
        return number.replaceAll("\\b(\\d{4})(\\d{8})(\\d{4})", "$1XXXXXXXX$3");
    }
}
