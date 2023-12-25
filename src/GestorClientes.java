import java.util.ArrayList;

public class GestorClientes {
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
        for(i=0;i<clientes.size();i++){
            System.out.println(clientes.get(i).getNombre() + ": " + clientes.get(i).getId());
        }
    }
    public void recuperarCliente(String dni){
        int i;
        for(i=0;i<clientes.size();i++){
            if(clientes.get(i).getId().equals(dni)){
                System.out.println("DNI: " + clientes.get(i).getId());
                System.out.println("Nombre: " + clientes.get(i).getNombre());
                System.out.println("Teléfono: " + clientes.get(i).getTelefono());
            }
        }
    }

}
