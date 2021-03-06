package eventum.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "palestra")
public class Palestra implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String titulo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private Date dataHora;
    
    private int duracao;
    
    // RELACIONAMENTO PALESTRA-LOCAL
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    private Local local;
    
    // RELACIONAMENTO PALESTRA-PALESTRANTES
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "palestra_id")
    private List<Palestrante> palestrantes;

    // CONSTRUTOR SEM ARGUMENTOS
    public Palestra() {
    }

    // GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Palestrante> getPalestrantes() {
        return palestrantes;
    }

    public void setPalestrantes(List<Palestrante> palestrantes) {
        this.palestrantes = palestrantes;
    }
    
    // HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    //EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palestra other = (Palestra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Palestra{" + "id=" + id + ", titulo=" + titulo + ", dataHora=" + dataHora + ", duracao=" + duracao + ", local=" + local + ", palestrantes=" + palestrantes + '}';
    }
    
    
  
}
