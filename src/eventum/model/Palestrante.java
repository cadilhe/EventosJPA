package eventum.model;
// Generated 29/11/2017 21:51:00 by Hibernate Tools 4.3.1

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "palestrante")
public class Palestrante implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Integer id;
    
    private String nome;
    
    @Column(name = "mini_bio")
    private String miniBio;
    
    @ManyToOne
    private Palestra palestra;
    
    // CONSTRUTOR
    public Palestrante() {        
    }
    
    
    // GETTERS E SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMiniBio() {
        return miniBio;
    }

    public void setMiniBio(String miniBio) {
        this.miniBio = miniBio;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }
    
    
    // HASHCODE, EQUALS, TOSTRING

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
        final Palestrante other = (Palestrante) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Palestrante{" + "id=" + id + ", nome=" + nome + ", miniBio=" + miniBio + ", palestra=" + palestra + '}';
    }
    
    
}
