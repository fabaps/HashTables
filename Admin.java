import java.io.*;

public class Admin {
  public static void main (String[] args) throws Exception{
    BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

    TablaUsuarios tabla = new TablaUsuarios();
    
    System.out.println("BIENVENIDO AL MANEJO DE USUARIOS");
    System.out.println();

    while (true){
      System.out.print("1. Ingreso de usuarios\n");
      System.out.print("2. Busqueda Passwords\n");
      System.out.print("3. Remover Usuario\n");
      System.out.print("4. Salir\n");
      System.out.print("Ingrese opción: ");
      int opcion = Integer.parseInt(tec.readLine());

      if(opcion == 1){
        System.out.print("Ingrese username: ");
        String user = tec.readLine();
        if (tabla.search(user) == true){
          System.out.println("Ya existe usuario");
          System.out.println();
        } else {
          System.out.print("Ingrese nombre: ");
          String nombre = tec.readLine();
          System.out.print("Ingrese password: ");
          String password = tec.readLine();
          tabla.insert(user,nombre,password);
          System.out.println();
          System.out.printf("Se ingreso a %s : %s : %s\n", user,nombre,password);
          System.out.println();
        }
      } else if (opcion == 2){
        System.out.print("Ingrese username: ");
        String user = tec.readLine();
        tabla.getPassword(user);
      } else if (opcion == 3){
        System.out.print("Ingrese username: ");
        String user = tec.readLine();
        tabla.delete(user);
        
      } else if (opcion == 4){
        System.out.println("Saliendo...");
        break;
      } else {
        System.out.println("Ingrese opción valida (1-4)");
      }

    }




  }
}