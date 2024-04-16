package com.carro.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ValidaPlaca {
    private static Boolean setPlacaAntiga(String placa) {
        String regex = "^[A-Z]{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }

    private static Boolean setPlacaNova(String placa){
        String regex = "^[A-Z]{3}\\d[A-Z]\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }

    public static Boolean validar(String placa){
        return setPlacaAntiga(placa) || setPlacaNova(placa);
    }
}
