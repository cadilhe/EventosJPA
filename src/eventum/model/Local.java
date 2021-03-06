package eventum.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
public class Local implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String predio;

    private String sala;

    private int capacidade;

    // RELACIONAMENTO LOCAL-PALESTRA
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "local",
            targetEntity = Palestra.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    private final List<Palestra> palestras = new ArrayList<Palestra>();

    // CONSTRUTOR SEM ARGUMENTOS
    public Local() {
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
