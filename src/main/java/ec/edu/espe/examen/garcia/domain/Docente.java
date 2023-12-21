package ec.edu.espe.examen.garcia.domain;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

import java.sql.Date;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "DOCENTE")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DOCENTE", nullable = false)
    private Integer codDocente;

    @Column(name = "COD_ESPECIALIDAD", nullable = false, length = 10)
    private String codEspecialidad;

    @Column(name = "CEDULA", nullable = false, length = 10)
    private String cedula;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @ManyToOne()
    @JoinColumn(name = "COD_ESPECIALIDAD", updatable = false, insertable = false)
    private Especialidad especialidad;

    @Version
    private Long version;

    public Docente() {
    }

    public Docente(Integer docente) {
        this.docente = docente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((docente == null) ? 0 : docente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Docente other = (Docente) obj;
        if (docente == null) {
            if (other.docente != null)
                return false;
        } else if (!docente.equals(other.docente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Docente [docente=" + docente + ", codEspecialidad=" + codEspecialidad + ", cedula=" + cedula
                + ", nombre=" + nombre + ", fechaIngreso=" + fechaIngreso + ", titulo=" + titulo + ", especialidad="
                + especialidad + ", version=" + version + "]";
    }

    
}
