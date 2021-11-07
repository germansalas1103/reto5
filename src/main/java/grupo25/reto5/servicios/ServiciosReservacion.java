package grupo25.reto5.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo25.reto5.reportes.ContadorClientes;
import grupo25.reto5.reportes.StatusReservas;
import grupo25.reto5.modelo.Reservacion;
import grupo25.reto5.repositorio.RepositorioReservacion;

/**
 * @author Andres Valencia Trujillo
 * @version 1.0 del 2021-10-28
 */
@Service
public class ServiciosReservacion {
    @Autowired
    /** Objeto de tipo RepositorioReservacion para ser usado en la clase */
    private RepositorioReservacion metodosCrud;
    
    /**
     * Metodo usado para listar todo el contenido de la tabla Reservacion
     * @return el metodo getAll del CrubRepository
     */
    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }

    /**
     * Metodo usado para listar una reservación deacuerdo a su id
     * @param reservationId
     * @return un get por id del CrudRepository
     */
    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    /**
     * Metodo que guarda un dato en la tabla Reservacion
     * @param reservation
     * @return La reservación guardada
     */
    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservacion> entry= metodosCrud.getReservation(reservation.getIdReservation());
            if(entry.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    /**
     * Metodo que actualiza un dato de la tabla Reservacion
     * @param reservacion
     * @return la reserva actualizada
     */
    public Reservacion update(Reservacion reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservacion> entry= metodosCrud.getReservation(reservacion.getIdReservation());
            if(!entry.isEmpty()){

                if(reservacion.getStartDate()!=null){
                    entry.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    entry.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStatus()!=null){
                    entry.get().setStatus(reservacion.getStatus());
                }
                metodosCrud.save(entry.get());
                return entry.get();
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }

    /**
     * Metodo que borra un dato de la tabla Reservacion
     * @param reservationId
     * @return Un booleano Verdadero si se encuentra la reserva o Falso si no existe
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Metodo que realiza un reporte según el status de la reservación
     * @return El status de la reserva ya sea completada o cancelada
     */
    public StatusReservas reporteStatusServicio (){
        List<Reservacion>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservacion>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size());
    }
    
    /**
     * Metodo que realiza un reporte de las reservaciones en un rango de fecha
     * @param datoA Es una fecha
     * @param datoB Es una fecha
     * @return Las reservas realizadas en el rango de fecha indicado
     */
    public List<Reservacion> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     
    /**
     * Metodo que realiza un reporte de las reservaciones por cliente
     * @return la lista de los clientes con reservaciones
     */
    public List<ContadorClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        } 


}
