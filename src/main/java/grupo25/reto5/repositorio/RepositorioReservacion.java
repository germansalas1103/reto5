package grupo25.reto5.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo25.reto5.reportes.ContadorClientes;
import grupo25.reto5.interfaces.InterfaceReservacion;
import grupo25.reto5.modelo.Cliente;
import grupo25.reto5.modelo.Reservacion;

@Repository
public class RepositorioReservacion {
    @Autowired
    private InterfaceReservacion crud4;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }
    public Optional<Reservacion> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservacion save(Reservacion reservacion){
        return crud4.save(reservacion);
    }
     public void delete(Reservacion reservacion){
        crud4.delete(reservacion);
    }

    public List<Reservacion> ReservacionStatusRepositorio (String status){
        return crud4.findAllByStatus(status);
    }
    
    public List<Reservacion> ReservacionTiempoRepositorio (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((long) report.get(i)[1], (Cliente) report.get(i)[0]));
        }
        return res;
    }
}
