package regrexandstring.bai_tap;

public class NameValidTest {
    private static  NameValid nameValid;
    public static final String[] validName=new String[]{"C0234G","A0134I","P9801K","C0113L","A1234M","P2030H"};
    public static final String[] inValidName=new String[]{"C024G","A013E","P9801O","C0113O","A1234Q","P2030N"};

    public static void main(String[] args) {
        nameValid=new NameValid();
        for(String name:validName){
            boolean isValid=nameValid.validate(name);
            System.out.println("Name is " + name +" is valid: "+ isValid);

        }
        for(String name:inValidName){
            boolean isValid=nameValid.validate(name);
            System.out.println("Name is " + name+" is valid: "+isValid);
        }
    }
}
