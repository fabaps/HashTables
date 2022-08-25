import java.util.regex.Pattern;

public class Usuario{

  //Campos
  private String username;
  private String nombre;
  private String password;

  //Constructor
  public Usuario(String username, String nombre, String password) throws InvalidUsernameException, NullPasswordException {
    if (Pattern.matches("^[a-z0-9_]{5,15}@([a-z]+\\.)([a-z]{1,3})", username)) {
      this.username = username;
    } else {
      throw new InvalidUsernameException();
    }
    this.nombre = nombre;
    if(password.length() == 0){
      throw new NullPasswordException();
    } else {
      this.password = password;
    }
  }

  //Metodos
  public String getContraseña(){
    return this.password;
  }

  public String getName(){
    return this.nombre;
  }

  public String getUsername(){
    return this.username;
  }

  
}



//CLASES DE EXCEPTIONS
class InvalidUsernameException extends Exception{

  public InvalidUsernameException(){
    super("El username no es válido");
  }
  
}

class NullPasswordException extends Exception{

  public NullPasswordException(){
    super("La contraseña esta vacía");
  }

}