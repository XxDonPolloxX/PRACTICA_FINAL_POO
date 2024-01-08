/**
 * Esta clase contiene el menú principal del programa.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class Menu {
    private GestorGeneralSingleton gestor;

    /**
     * Este es el constructor de la clase.
     * @param gestor es el gestor general del programa.
     */
    public Menu(GestorGeneralSingleton gestor){
        this.gestor = gestor;
    }

    /**
     * Este método muestra las opciones del menú principal.
     */
    public void opciones(){
    System.out.println("");
    System.out.println("MENÚ PRINCIPAL");
    System.out.println("Selecciona una opción:");
    System.out.println("1. Gestión de bungalos");
    System.out.println("2. Gestión de clientes");
    System.out.println("3. Gestión de actividades");
    System.out.println("4. Gestión de facturas");
    System.out.println("5. Gestión de reservas");
    System.out.println("0. Salir del programa");
    }

    /**
     * @return devuelve la opción elegida.
     */
    public int seleccionarOpcion(){
        int opcion;
        opcion = MyInput.readInt();
        if(opcion<0 || opcion>5){
            System.out.println("Formato de opción no válido");
            return -1;
        }
        return opcion;
    }

    /**
     * Este método ejecuta la opción elegida.
     * @param opcion es la opción elegida.
     */
    public void ejecutar(int opcion){
        switch (opcion){
            case 1:
                gestor.getBungalos().menuBungalos();
                break;
            case 2:
                gestor.getClientes().menuClientes();
                break;
            case 3:
                gestor.getActividades().menuActividades();
                break;
            case 4:
                gestor.getFacturas().menuFacturas();
                break;
            case 5:
                gestor.getBungalos().menuReservas();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                break;


        }
    }

    /**
     * Este método ejecuta el menú principal.
     */
    public void ejecutar(){
        int opcionMenu = 0;
        do{
            opciones();
            opcionMenu = seleccionarOpcion();
            ejecutar(opcionMenu);


        }while(!(opcionMenu ==0));
    }

}
