package br.com.desafio.totalshake.exception;

public class PedidoNotFoundException extends RuntimeException{

    public PedidoNotFoundException(){
        super();
    }

    public PedidoNotFoundException(String message) {
        super(message);
    }

    public PedidoNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

}
