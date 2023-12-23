import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private String id;
    private float costeTotal;
    private Date fechaFacturacion;
    private static int numFactura;
    private Cliente cliente;
    private ReservaBungalo reservas;

    public Factura(Cliente c, String id_Reserva, Date fecha_factura){
        id = calcular_id();
        cliente = c;
        fechaFacturacion = fecha_factura;
        reservas = cliente.recuperarReserva(id);
        numFactura += 1;

    }
    public String calcular_id(){
        String id, idf = "";
        int i;
        id = Integer.toString(numFactura);
        for (i=0;i<id.length();i++){
            idf = idf + "0";
        }
        idf = idf + id;

        return idf;
    }

}
