import java.time.LocalDate;
import java.util.ArrayList;

public class GestorFacturas {
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
        fechaFacturacion = LocalDate.now();
        for(i=0;i<bungalos.getBungalos().size();i++){
            for(j=0;j<bungalos.getBungalos().get(i).getReserva_0().getActividades().size();j++){
                if(bungalos.getBungalos().get(i).getReserva_0().getActividades().get(j).getId().equals(id)){
                    r = bungalos.getBungalos().get(i).getReserva_0().getActividades().get(j);
                    precio = r.getPrecio();
                }
            }
        }
        for(i=0;i<clientes.getClientes().size();i++){
            if(clientes.getClientes().get(i).getId().equals(r.getCliente())){
                cliente = clientes.getClientes().get(i);
            }
        }
        facturas.add(new Factura(cliente, precio, fechaFacturacion, r));
    }
    public void mostrarFacturasCliente(){
        String DNI;
        int i, j, k;
        System.out.println("Introduzca el DNI del cliente:");
        DNI = MyInput.readString();
        for(i=0;i<facturas.size();i++){
            if(facturas.get(i).getCliente().getId().equals(DNI)){
                System.out.println("Código: " + facturas.get(i).getId());
                System.out.println("DNI: " + DNI);
                System.out.println("Fecha: " + facturas.get(i).getFechaFacturacion());
                System.out.println();
            }
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
        System.out.println(f.getId());
        System.out.println(f.getCliente().getId());
        System.out.println(f.getCliente().getNombre());
        System.out.println(f.getCliente().getTelefono());
        System.out.println(f.getReservas().getId());
        System.out.println(f.getCosteTotal());
        System.out.println(f.getFechaFacturacion());


    }
}
