package br.com.desafio.totalshake.exception;

public class ItemPedidoNotFoundException extends RuntimeException{

    public ItemPedidoNotFoundException(){
        super();
    }

    public ItemPedidoNotFoundException(String message) {
        super(message);
    }

    public ItemPedidoNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

}
