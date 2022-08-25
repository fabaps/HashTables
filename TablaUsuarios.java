import java.util.HashMap;

public class TablaUsuarios{

  //Campos
  private HashMap<String,Usuario> usuarios;

  //Constructor
  public TablaUsuarios(){
    this.usuarios = new HashMap<String,Usuario>(15);
  }

  public void insert(String username, String nombre, String password) throws UserAlreadyExistsException, InvalidUsernameException, NullPasswordException {
    if (usuarios.containsKey(username)){
      throw new UserAlreadyExistsException();
    } else {
      Usuario nuevo = new Usuario(username, nombre, password);
      usuarios.put(username,nuevo);
    }
  }

  public void delete(String username) throws UserDoesNotExistException{
    if(usuarios.containsKey(username)){
      usuarios.remove(username);
      System.out.println("Se elimino a: " + username);
    } else{
      throw new UserDoesNotExistException();
    }
  }

  public boolean search(String username){
    if (usuarios.containsKey(username)){
      return true;
    } else {
      return false;
    }
  }

  public void getPassword(String username) throws UserDoesNotExistException {
    if (usuarios.containsKey(username)){
      Usuario encontrado = usuarios.get(username);
      System.out.println();
      System.out.println("Username: " + username);
      System.out.println("Password: " + encontrado.getContraseña());
      System.out.println();

    } else
      throw new UserDoesNotExistException();
  }

  



}

class UserAlreadyExistsException extends Exception{
  public UserAlreadyExistsException(){
    super("Usuario ya existe");
  }
}

class UserDoesNotExistException extends Exception{
  public UserDoesNotExistException(){
    super("Usuario no existe");
  }
}