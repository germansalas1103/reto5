package grupo25.reto5.reportes;

import grupo25.reto5.modelo.Cliente;

public class ContadorClientes {
    private Long total;
    private Cliente client;
    
    public ContadorClientes(Long total, Cliente client) {
        this.total = total;
        this.client = client;
       
    }

    public ContadorClientes() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    
    
       
}
