package pl.edu.agh.soa.projekt.pas.exception;

public class SessionAlreadyExistsException extends Exception {
    public SessionAlreadyExistsException() {
        super("Wygląda na to, że twoja sesja poprzednia sesja nie wygasła");
    }
}