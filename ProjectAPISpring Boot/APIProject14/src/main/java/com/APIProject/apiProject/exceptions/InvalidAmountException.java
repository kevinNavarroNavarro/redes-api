package com.APIProject.apiProject.exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String entity) {
        super("No se pudieron comprar las unidades de la Unidad id="+entity+ " dado a que no tiene suficientes " +
                "recursos. ");
    }
}