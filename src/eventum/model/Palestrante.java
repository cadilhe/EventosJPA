package eventum.model;

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
public class Palestrante implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Long id;
    
    private String nome;
    
    @Column(name = "mini_bio")
    private String miniBio;
    
    // RELACIONAMENTO PALESTRANTE-PALESTRA
    @ManyToOne
    private Palestra palestra;
    
    // CONSTRUTOR SEM ARGUMENTOS
    public Palestrante() {        
    }
    
    
    // GETTERS E SETTERS
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
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
    
    
    // HASHCODE
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    // EQUALS
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

    // TOSTRING
    @Override
    public String toString() {
        return "Palestrante{" + "id=" + id + ", nome=" + nome + ", miniBio=" + miniBio + ", palestra=" + palestra + '}';
    }
    
    
}
