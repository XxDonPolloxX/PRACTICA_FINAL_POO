import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class GestorGeneralSingleton implements Serializable {
    private GestorClientes clientes;
    private GestorActividades actividades;
    private GestorBungalos bungalos;
    private GestorFacturas facturas;
    private static GestorGeneralSingleton instance;
    private GestorGeneralSingleton(){
        clientes = new GestorClientes();
        actividades = new GestorActividades();
        bungalos = new GestorBungalos(clientes, actividades);
        facturas = new GestorFacturas(clientes, bungalos);
        instance = this;
    }
    public GestorFacturas getFacturas(){return facturas;}
    public GestorClientes getClientes(){return clientes;}
    public GestorActividades getActividades(){return actividades;}
    public GestorBungalos getBungalos(){return bungalos;}
    public static GestorGeneralSingleton ObtenerInstancia(){
        if(instance==null){
            instance = deserialize("fichero.dat");
            if(instance==null){
                instance = new GestorGeneralSingleton();
            }

        }
        return instance;
    }
    private static <A> A deserialize(String nombreFichero) {
        try {
            FileInputStream fis = new FileInputStream(nombreFichero) ;
            ObjectInputStream iis = new ObjectInputStream(fis) ;
            return (A) iis.readObject() ;
        } catch (IOException e) {
            System.err.println("Problem: "+e);}
        catch(ClassNotFoundException e)
        { System.out.println(e.getMessage()); }
        return null ;
    }
}
