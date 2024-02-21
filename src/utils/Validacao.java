package utils;

import java.time.LocalDate;

public class Validacao {
    public static <T> boolean campoEhValido(T dado) {
        if (dado == null) {
            return false;
        } else if (dado instanceof String dadoString) {
            return !((String) dado).isEmpty();
        } else if (dado instanceof LocalDate dadoDate) {
            LocalDate dataDeReferencia = LocalDate.of(1888, 10, 14);
            return !dadoDate.isBefore(dataDeReferencia);
        } else if (dado instanceof Double dadoDouble) {
            return !dadoDouble.isNaN() && dadoDouble >= 0d;
        }

        return false;
    }

    public static <T> boolean validarDados(T... dados){
        boolean dadosValidos = true;
        for(Object dado : dados){
            if (!Validacao.campoEhValido(dado)){
                dadosValidos = false;
            }
        }
        return dadosValidos;
    }
}
