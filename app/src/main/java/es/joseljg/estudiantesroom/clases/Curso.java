package es.joseljg.estudiantesroom.clases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "cursos")
public class Curso implements Serializable {
    //-----------------------------------------------
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "curso")
    private String curso;

    @NonNull
    @ColumnInfo(name = "descripcion")
    private String descripcion;

    //-----------------------------------------------
    public Curso( @NonNull String curso,  @NonNull String descripcion) {
        this.curso = curso;
        this.descripcion = descripcion;
    }
    //-----------------------------------------------

    public String getCurso() {
        return curso;
    }

    public void setCurso( @NonNull String curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion( @NonNull String descripcion) {
        this.descripcion = descripcion;
    }
    //-------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso1 = (Curso) o;
        return curso.equals(curso1.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso);
    }
    //--------------------------------------------------

    @Override
    public String toString() {
 /*       return "Curso{" +
                "curso='" + curso + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
                */
    return this.curso;
    }

    //--------------------------------------------------
}
