public class GestorGeneralSingleton {
    private GestorClientes clientes;
    private GestorActividades actividades;
    private GestorBungalos bungalos;
    private static GestorGeneralSingleton instance = null;
    private GestorGeneralSingleton(){
        clientes = new GestorClientes();
        actividades = new GestorActividades();
        bungalos = new GestorBungalos(clientes, actividades);
        instance = this;
    }
    public GestorGeneralSingleton ObtenerInstancia(){
        if(instance==null){
            instance = new GestorGeneralSingleton();
        }
        return instance;
    }
}
