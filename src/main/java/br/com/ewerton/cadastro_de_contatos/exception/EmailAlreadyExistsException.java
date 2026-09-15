package br.com.ewerton.cadastro_de_contatos.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) { super(message);}
}
