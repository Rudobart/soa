package pl.edu.agh.soa.projekt.pas.exception;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException() {
        super("Nieprawidłowa nazwa użytkownika lub hasło");
    }
}
