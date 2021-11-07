package grupo25.reto5.interfaces;

import org.springframework.data.repository.CrudRepository;

import grupo25.reto5.modelo.Cliente;

public interface InterfaceCliente extends CrudRepository<Cliente, Integer> {
    
}
