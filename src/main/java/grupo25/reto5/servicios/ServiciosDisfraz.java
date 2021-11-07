package grupo25.reto5.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo25.reto5.modelo.Disfraz;
import grupo25.reto5.repositorio.RepositorioDisfraz;

@Service
public class ServiciosDisfraz {
    @Autowired
    private RepositorioDisfraz metodosCrud;
    
    public List<Disfraz> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Disfraz> getDisfraz(int idDisfraz){
        return metodosCrud.getDisfraz(idDisfraz);
    }
    
    public Disfraz save(Disfraz costume){
        if(costume.getId()==null){
            return metodosCrud.save(costume);
        }else{
            Optional<Disfraz> evt=metodosCrud.getDisfraz(costume.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(costume);
            }else{
                return costume;
            }
        }
    }
    public Disfraz update(Disfraz costume){
        if(costume.getId()!=null){
            Optional<Disfraz> e=metodosCrud.getDisfraz(costume.getId());
            if(!e.isEmpty()){
                if(costume.getName()!=null){
                    e.get().setName(costume.getName());
                }
                if(costume.getBrand()!=null){
                    e.get().setBrand(costume.getBrand());
                }
                if(costume.getYear()!=null){
                    e.get().setYear(costume.getYear());
                }
                if(costume.getDescription()!=null){
                    e.get().setDescription(costume.getDescription());
                }
                if(costume.getCategory()!=null){
                    e.get().setCategory(costume.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return costume;
            }
        }else{
            return costume;
        }
    }


    public boolean deleteOrtesis(int costumeId) {
        Boolean aBoolean = getDisfraz(costumeId).map(costume -> {
            metodosCrud.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
