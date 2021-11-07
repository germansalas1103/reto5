package grupo25.reto5.repositorio;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo25.reto5.interfaces.InterfaceMensaje;
import grupo25.reto5.modelo.Mensaje;

@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud3;
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud3.findAll();
    }
    public Optional<Mensaje> getMessage(int id){
        return crud3.findById(id);
    }

    public Mensaje save(Mensaje message){
        return crud3.save(message);
    }
     public void delete(Mensaje mensaje){
        crud3.delete(mensaje);
    }
}