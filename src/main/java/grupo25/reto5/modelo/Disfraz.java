package grupo25.reto5.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "costume")
/**
 * @author Andres Valencia Trujillo
 * @version 1.0 del 2021-10-28
 */
public class Disfraz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id; /**Atributo id */
    private String name;    /**Atributo nombre */
    private String brand;   /**Atributo marca */
    private Integer year;   /**Atributo año */    
    private String description; /**Atributo descripción */
    
    @ManyToOne
    @JoinColumn(name="categoryid")
    @JsonIgnoreProperties("costumes")
    private Categoria category; /**Atributo categoría */
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "costume")
    @JsonIgnoreProperties({"costume","client"})
    private List<Mensaje> messages; /**Atributo mensaje */

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "costume")
    @JsonIgnoreProperties({"costume","message"})
    public List<Reservacion> reservations;  /**Atributo reservación */

    /**
     * Metodo getter del atributo id
     * @return el id de la clase costume
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo setter del atributo id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo getter del atributo name
     * @return el nombre de la clase costume
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo setter del atributo name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo getter del atributo brand
     * @return la marca de la clase costume
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Metodo setter del atributo brand
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Metodo getter del atributo year
     * @return el año asignado a la clase costume
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Metodo setter del atributo year
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Netodo getter del atributo decription
     * @return la descripción de la clase costume
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo setter del atributo description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo getter del atributo category
     * @return el id de la categoria relacionada
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     * Metodo setter del atributo category
     * @param category
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * Metodo getter del atributo message
     * @return el id del mensaje relacionado
     */
    public List<Mensaje> getMessages() {
        return messages;
    }

    /**
     * Metodo setter del atributo message
     * @param messages
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    /**
     * Metodo getter del atributo reservation
     * @return el id de la reservación relacionada
     */
    public List<Reservacion> getReservations() {
        return reservations;
    }

    /**
     * Metodo setter del atributo reservation
     * @param reservations
     */
    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }
    
}