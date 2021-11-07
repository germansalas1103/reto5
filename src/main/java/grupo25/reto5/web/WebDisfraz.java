package grupo25.reto5.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

import grupo25.reto5.modelo.Disfraz;
import grupo25.reto5.servicios.ServiciosDisfraz;

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class WebDisfraz {
    @GetMapping("/holaMundo")
    public String saludar(){
    return "Hola Mundo -- Bienvenidos al Reto 3 y 4";
    }
    
    @Autowired
    private ServiciosDisfraz servicio;
    @GetMapping("all")
    public List <Disfraz> getDisfraz(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Disfraz> getOrthesis(@PathVariable("id") int idDisfraz) {
        return servicio.getDisfraz(idDisfraz);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz save(@RequestBody Disfraz disfraz) {
        return servicio.save(disfraz);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz update(@RequestBody Disfraz disfraz) {
        return servicio.update(disfraz);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int disfrazId) {
        return servicio.deleteOrtesis(disfrazId);
    }
}
