package br.com.dlm.picpayclone.exceptions;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String messege) {
        super(messege);
    }

    public BusinessException(String messege, Exception exception) {
        super(messege, exception);
    }
}
