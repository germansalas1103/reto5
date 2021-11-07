package grupo25.reto5.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo25.reto5.interfaces.InterfaceDisfraz;
import grupo25.reto5.modelo.Disfraz;

@Repository
public class RepositorioDisfraz {
    @Autowired
    private InterfaceDisfraz crud;
    

    public List<Disfraz> getAll(){
        return (List<Disfraz>) crud.findAll();       
    }
    
    public Optional <Disfraz> getDisfraz(int id){
        return crud.findById(id);
    }
    
    public Disfraz save(Disfraz costume){
        return crud.save(costume);
    }
      public void delete(Disfraz costume){
        crud.delete(costume);
    }

}
