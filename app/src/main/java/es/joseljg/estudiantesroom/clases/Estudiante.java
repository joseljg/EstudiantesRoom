package es.joseljg.estudiantesroom.clases;

import java.io.Serializable;
import java.util.Objects;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "estudiantes",
        indices = {@Index(value = {"dni"})},
        foreignKeys = {
                @ForeignKey(entity = Curso.class,
                        parentColumns = "curso",
                        childColumns = "idcurso",
                        onUpdate= ForeignKey.CASCADE,
                        onDelete = ForeignKey.RESTRICT)
        })

/*
@Entity(tableName = "estudiantes")
*/
public class Estudiante implements Serializable {
    //---------------------------------------------------
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "dni")
    private String dni;
    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "idcurso", index = true)
    private String curso;
    @NonNull
    @ColumnInfo(name = "fechan")
    private String fechan;
    @NonNull
    @ColumnInfo(name = "horap")
    private String horap;
    //---------------------------------------------------
    public Estudiante(@NonNull String dni, @NonNull String nombre, @NonNull String curso, @NonNull String fechan, @NonNull String horap) {
        this.dni = dni;
        this.nombre = nombre;
        this.curso = curso;
        this.fechan = fechan;
        this.horap = horap;
    }
    //---------------------------------------------------
    public String getDni() {
        return dni;
    }

    public void setDni(@NonNull String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(@NonNull String curso) {
        this.curso = curso;
    }

    public String getFechan() {
        return fechan;
    }

    public void setFechan( @NonNull String fechan) {
        this.fechan = fechan;
    }

    public String getHorap() {
        return horap;
    }

    public void setHorap(@NonNull String horap) {
        this.horap = horap;
    }
    //--------------------------------------------------------
    @Override
    public String toString() {
        return "Estudiante{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", fechan='" + fechan + '\'' +
                ", horap='" + horap + '\'' +
                '}';
    }
    //---------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return dni.equals(that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    //---------------------------------------------------------
}
