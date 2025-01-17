package br.com.ecommerce.orders.exception.productExeptions;


public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}
