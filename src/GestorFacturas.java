import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorFacturas implements Serializable {
    private GestorClientes clientes;
    private GestorBungalos bungalos;
    private ArrayList<Factura> facturas;
    public GestorFacturas(GestorClientes clientes, GestorBungalos bungalos){
        this.bungalos = bungalos;
        this.clientes = clientes;
        this.facturas = new ArrayList<Factura>();
    }
    public void generarFactura(){
        String id;
        Reserva r = null;
        int i, j;
        float precio = 0;
        Cliente cliente = null;
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
            facturas.add(new Factura(cliente, precio, fechaFacturacion, r));
        }
        else{
            System.out.println("Error: No se puede generar una factura de una reserva que no ha finalizado");
        }

    }
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
            System.out.println(f.getId());
            System.out.println(f.getCliente().getId());
            System.out.println(f.getCliente().getNombre());
            System.out.println(f.getCliente().getTelefono());
            System.out.println(f.getReservas().getId());
            System.out.println(f.getCosteTotal());
            System.out.println(f.getFechaFacturacion());
        }



    }
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
