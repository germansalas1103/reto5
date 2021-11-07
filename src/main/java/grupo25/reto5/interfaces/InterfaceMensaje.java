package grupo25.reto5.interfaces;

import org.springframework.data.repository.CrudRepository;

import grupo25.reto5.modelo.Mensaje;

public interface InterfaceMensaje extends CrudRepository<Mensaje, Integer> {
    
}
