import java.io.*;
import java.util.regex.Pattern;

public class Test {
  public static void main(String[] args) throws Exception{

    BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

     
    while(true){ 
      System.out.print("Regex: ");
      String correo = tec.readLine();

      if (Pattern.matches("^[a-z0-9_]{5,15}@([a-z]+\\.)([a-z]{1,3})", correo)) {
        System.out.println("Valido");
      }
    }
      
    


  }
}