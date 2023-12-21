package ec.edu.espe.examen.garcia.domain;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "DOCENTE_MATERIA")
public class DocenteMateria {
    @EmbeddedId
    private DocenteMateriaPK PK;

    @Column(name = "PERIODO", nullable = false, length = 10)
    private String periodo;

    @Column(name = "ALUMNOS_MATRICULADOS", nullable = false)
    private Integer alumnosMatriculados;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "PROMEDIO_CURSO", nullable = true, precision = 4, scale = 2)
    private BigDecimal promedioCurso;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimoCambio;

    @ManyToOne()
    @JoinColumn(name = "COD_DOCENTE", updatable = false, insertable = false)
    private Docente docente;

    @ManyToOne()
    @JoinColumn(name = "COD_MATERIA", updatable = false, insertable = false)
    private Materia materia;

    @Version
    private Long version;

    public DocenteMateria() {
    }

    public DocenteMateria(DocenteMateriaPK pK) {
        PK = pK;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((PK == null) ? 0 : PK.hashCode());
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
        DocenteMateria other = (DocenteMateria) obj;
        if (PK == null) {
            if (other.PK != null)
                return false;
        } else if (!PK.equals(other.PK))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DocenteMateria [PK=" + PK + ", periodo=" + periodo + ", alumnosMatriculados=" + alumnosMatriculados
                + ", estado=" + estado + ", promedioCurso=" + promedioCurso + ", fechaUltimoCambio=" + fechaUltimoCambio
                + ", docente=" + docente + ", materia=" + materia + ", version=" + version + "]";
    }

}
