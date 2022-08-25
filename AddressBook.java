import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class AddressBook{
  public static void main(String[] args) throws Exception{
    BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String,Contact> contactos = new HashMap<String,Contact>();

    while(true){
      System.out.print("1. Ingresar contacto\n");
      System.out.print("2. Eliminar\n");
      System.out.print("3. Buscar\n");
      System.out.print("4. Salir\n");
      System.out.println();
      System.out.print("Ingrese opcion: ");
      int opcion = Integer.parseInt(tec.readLine());

      if(opcion == 1){
        System.out.print("Ingrese nombre: ");
        String nombre = tec.readLine();
        if(contactos.containsKey(nombre)){
          Contact encontrado = contactos.get(nombre);
          System.out.println();
          System.out.println("Contacto ya existe");
          System.out.print("¿Agregar otro teléfono? (S/N)");
          String op = tec.readLine();
          if(op.equals("S")){
            System.out.print("Ingrese telefono: ");
            String tel = tec.readLine();
            LinkedList<String> teles = encontrado.getTelefonos();
            teles.add(1,tel);
          }
          
          
        } else {
          System.out.print("Ingrese dirección: ");
          String direccion = tec.readLine();
          System.out.print("Ingrese telefono: ");
          String telefono = tec.readLine();
          Contact nuevo = new Contact(nombre, direccion, telefono);
          System.out.println("Se agrego: " + nuevo);
          contactos.put(nombre, nuevo);

          
        }
      } else if (opcion == 2){
        System.out.print("Ingrese nombre: ");
        String nombre = tec.readLine();
        if(contactos.containsKey(nombre)){
          Contact encontrado = contactos.get(nombre);
          System.out.println("Se elimino a: " + nombre);
          contactos.remove(nombre);
        } else {
          System.out.println();
          System.out.println("No existe contacto");
          System.out.println();
        }



      } else if (opcion == 3){
        System.out.print("Ingrese nombre: ");
        String nombre = tec.readLine();
        if(contactos.containsKey(nombre)){
          Contact encontrado = contactos.get(nombre);
          System.out.println("Contacto: " + encontrado);
        } else {
          System.out.println("No existe contacto");
        }


      } else if (opcion == 4){
        System.out.println();
        System.out.println("Saliendo...");
        break;
      } else {
        System.out.println();
        System.out.println("Opción inválida");
        System.out.println();
      }
    }



  }
}