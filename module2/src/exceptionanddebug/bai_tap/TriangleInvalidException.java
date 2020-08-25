package exceptionanddebug.bai_tap;

public class TriangleInvalidException extends Exception{
    private String message;
    public TriangleInvalidException(String message){
        super(message);
        this.message=message;
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
