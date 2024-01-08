import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Esta clase representa el gestor general del camping. Es un singleton, por lo que solo puede haber una instancia de esta clase.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class GestorGeneralSingleton implements Serializable {
    //para que no me genene un numero distinto cada vez y pierda los datos metidos
    private static final long serialVersionUID = 1L;
    private GestorClientes clientes;
    private GestorActividades actividades;
    private GestorBungalos bungalos;
    private GestorFacturas facturas;
    private static GestorGeneralSingleton instance;

    /**
     * Este es el constructor de la clase.
     */
    private GestorGeneralSingleton(){
        clientes = new GestorClientes();
        actividades = new GestorActividades();
        bungalos = new GestorBungalos(clientes, actividades);
        facturas = new GestorFacturas(clientes, bungalos);
        instance = this;
    }

    /**
     * Este método devuelve el gestor de facturas.
     */
    public GestorFacturas getFacturas(){return facturas;}

    /**
     * Este método devuelve el gestor de clientes.
     */
    public GestorClientes getClientes(){return clientes;}

    /**
     * Este método devuelve el gestor de actividades.
     */
    public GestorActividades getActividades(){return actividades;}

    /**
     * Este método devuelve el gestor de bungalos.
     */
    public GestorBungalos getBungalos(){return bungalos;}

    /**
     * Este método devuelve la instancia del singleton.
     */
    public static GestorGeneralSingleton ObtenerInstancia(){
        if(instance==null){
            instance = deserialize("fichero.dat");
            if(instance==null){
                instance = new GestorGeneralSingleton();
            }

        }
        return instance;
    }

    /**
     * Este método deserializa el singleton.
     * @param nombreFichero es el nombre del fichero que se quiere deserializar.
     * @param <A> es el tipo de objeto que se quiere deserializar.
     */
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
