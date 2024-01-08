import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase representa un gestor de facturas del camping.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class GestorFacturas implements Serializable {
    private GestorClientes clientes;
    private GestorBungalos bungalos;
    private ArrayList<Factura> facturas;
    private int numFactura = 0;

    /**
     * Este es el constructor de la clase.
     * @param clientes son los clientes del camping.
     * @param bungalos son los bungalos del camping.
     */
    public GestorFacturas(GestorClientes clientes, GestorBungalos bungalos){
        this.bungalos = bungalos;
        this.clientes = clientes;
        this.facturas = new ArrayList<Factura>();
    }

    /**
     * Este método genera una factura.
     */
    public void generarFactura(){
        String id;
        Reserva r = null;
        int i, j;
        float precio = 0;
        Cliente cliente = null;
        ArrayList<String> conceptos = new ArrayList<>();
        LocalDate fechaFacturacion;
        System.out.println("Introduzca el id de la reserva a facturar:");
        id = MyInput.readString();
        for(i=0;i<facturas.size();i++){
            if(facturas.get(i).getReservas().getId().equals(id)){
                System.out.println("No se pueden generar dos facturas de una misma reserva");
                return;
            }
        }
        System.out.println("Introduce la fecha de facturación:");
        fechaFacturacion = LocalDate.parse(MyInput.readString());




        for(i=0;i<bungalos.getBungalos().size();i++){
            for(j=0;j<bungalos.getBungalos().get(i).getReserva_0().getActividades().size();j++){
                if(bungalos.getBungalos().get(i).getReserva_0().getActividades().get(j).getId().equals(id)){
                    r = bungalos.getBungalos().get(i).getReserva_0().getActividades().get(j);
                    conceptos.add("Bungalow con codigo:  " + bungalos.getBungalos().get(i).getId() + " nombre: "+ bungalos.getBungalos().get(i).getNombre() + " con precio diario: " + bungalos.getBungalos().get(i).getPrecio());
                    precio = r.getPrecio();
                }
            }
        }
        if(r == null){
            System.out.println("No se ha encontrado la reserva");
            return;
        }

        for(i=0;i<clientes.getClientes().size();i++){
            if(clientes.getClientes().get(i).getId().equals(r.getCliente())){
                cliente = clientes.getClientes().get(i);
            }
        }

        if(r.getFechaFin().isBefore(fechaFacturacion) || r.getFechaFin().isEqual(fechaFacturacion)){
            facturas.add(new Factura(cliente, precio, fechaFacturacion, r, numFactura,conceptos));
            System.out.println("Factura generada con éxito, numero de factura: " + facturas.getLast().getId());
            numFactura++;
        }
        else{
            System.out.println("Error: No se puede generar una factura de una reserva que no ha finalizado");
        }

    }

    /**
     * Este método muestra las facturas de un cliente.
     */
    public void mostrarFacturasCliente(){
        String DNI;
        int i, j, k;
        boolean flag = false;
        System.out.println("Introduzca el DNI del cliente:");
        DNI = MyInput.readString();
        for(i=0;i<facturas.size();i++){
            if(facturas.get(i).getCliente().getId().equals(DNI)){
                System.out.println("Código: " + facturas.get(i).getId());
                System.out.println("DNI: " + DNI);
                System.out.println("Fecha: " + facturas.get(i).getFechaFacturacion());
                System.out.println();
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Error: Cliente no encontrado");
        }
    }

    /**
     * Este método muestra los datos de una factura.
     */
    public void datosFactura(){
        String DNI, idFactura;
        int i, j, k;
        Factura f = null;
        System.out.println("Introduzca el DNI del cliente:");
        DNI = MyInput.readString();
        System.out.println("Introduce el identificador de la factura:");
        idFactura = MyInput.readString();
        for(i=0;i<facturas.size();i++){
            if(facturas.get(i).getId().equals(idFactura) && facturas.get(i).getCliente().getId().equals(DNI)){
                f = facturas.get(i);
            }
        }
        if(f == null){
            System.out.println("Error: Datos no coincidentes");
        }
        else{
            f.mostrarFactura();
        }



    }

    /**
     * Este método muestra el menú de facturas.
     */
    public void menuFacturas(){
        String s;
        do{
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Generar factura");
            System.out.println("2. Mostrar facturas de un cliente");
            System.out.println("3. Mostrar datos de una factura");
            System.out.println("4. Volver al menú principal");
            s = MyInput.readString();
            switch(s){
                case "1":
                    generarFactura();
                    break;
                case "2":
                    mostrarFacturasCliente();
                    break;
                case "3":
                    datosFactura();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(!s.equals("4"));
    }
}
