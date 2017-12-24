package eventum.model;
// Generated 29/11/2017 21:51:00 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Local generated by hbm2java
 */
@Entity
@Table(name = "local")
public class Local implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String predio;

    private String sala;

    private int capacidade;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "local",
            targetEntity = Palestra.class,
            cascade = CascadeType.ALL)
    private final List<Palestra> palestras = new ArrayList<Palestra>();

    public Local() {
    }

    // Getters e Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPredio() {
        return this.predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public String getSala() {
        return this.sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<Palestra> getPalestras() {
        return palestras;
    }

}