package grupo25.reto5.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo25.reto5.interfaces.InterfaceCategoria;
import grupo25.reto5.modelo.Categoria;

@Repository
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud2;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) crud2.findAll();       
    }
    
    public Optional <Categoria> getCategoria(int id){
        return crud2.findById(id);
    }
    
    public Categoria save(Categoria categoria){
        return crud2.save(categoria);
    }
     public void delete(Categoria categoria){
        crud2.delete(categoria);
    }
}
