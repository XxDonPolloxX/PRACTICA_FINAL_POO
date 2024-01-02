import java.io.Serializable;
import java.util.ArrayList;

public class GestorClientes implements Serializable {
    private ArrayList<Cliente> clientes;
    public GestorClientes(){
        clientes = new ArrayList<Cliente>();
    }
    public ArrayList<Cliente> getClientes(){return clientes;}
    public void agregarCliente(){
        String DNI;
        String nombre;
        String telefono;
        System.out.println("Introduzca el DNI del cliente: ");
        DNI = MyInput.readString();
        System.out.println("Introduzca el nombre del cliente: ");
        nombre = MyInput.readString();
        System.out.println("Introduzca el teléfono del cliente: ");
        telefono = MyInput.readString();
        if(!validarDNI(DNI)){
            System.out.println("Error: el DNI no puede estar repetido");
        }
        else {
        clientes.add(new Cliente(DNI, nombre, telefono));
        System.out.println("El cliente: " + clientes.getLast().getId() + " se ha añadido con éxito");
        }
        }
    public boolean validarDNI(String dni){
        int i;
        for(i=0;i<clientes.size();i++){
            if(clientes.get(i).getId().equals(dni)){
                return false;
            }
        }
        return true;
    }
    public void listarClientes(){
        int i;
        if (clientes.size() == 0){
            System.out.println("No hay clientes");
        } else {
            for(i=0;i<clientes.size();i++){
               System.out.println(clientes.get(i).getNombre() + ": " + clientes.get(i).getId());
            }
        }
    }
    public void recuperarCliente(){
        int i;
        boolean flag = false;
        String DNI;
        System.out.println("Introduzca el DNI del cliente:");
        DNI = MyInput.readString();
        for(i=0;i<clientes.size();i++){
            if(clientes.get(i).getId().equals(DNI)){
                System.out.println("DNI: " + clientes.get(i).getId());
                System.out.println("Nombre: " + clientes.get(i).getNombre());
                System.out.println("Teléfono: " + clientes.get(i).getTelefono());
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Error: Cliente no encontrado");
        }
    }
    public void menuClientes(){
        String s;
        do{
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Recuperar cliente");
            System.out.println("4. Borrar cliente");
            System.out.println("5. Volver al menú principal");
            s = MyInput.readString();
            switch(s){
                case "1":
                    agregarCliente();
                    break;
                case "2":
                    listarClientes();
                    break;
                case "3":
                    recuperarCliente();
                    break;

                 case "4":
                    borrarCliente();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(!s.equals("5"));

    }

        public void borrarCliente(){
            int i;
            boolean flag = false;
            String DNI;
            System.out.println("Introduzca el DNI del cliente:");
            DNI = MyInput.readString();
            for(i=0;i<clientes.size();i++){
                if(clientes.get(i).getId().equals(DNI)){
                    clientes.remove(i);
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("Error: Cliente no encontrado");
            }
        }

}
