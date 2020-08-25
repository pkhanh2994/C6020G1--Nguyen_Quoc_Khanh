package exceptionanddebug.bai_tap;

public class TriangleRuntimeException extends RuntimeException {
    private String message;

    public TriangleRuntimeException(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
