package es.joseljg.estudiantesroom.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.joseljg.estudiantesroom.clases.Estudiante;

@Dao
public interface DAOEstudiante {

    @Insert
    void insert(Estudiante estudiante);

    @Delete
    void delete(Estudiante estudiante);

    @Query("DELETE FROM estudiantes")
    void deleteAll();

    @Update
    void update(Estudiante estudiante);

    @Query("SELECT * from estudiantes ORDER BY dni ASC")
    LiveData<List<Estudiante>> cogerTodosLosEstudiantes();


    @Query("SELECT * FROM estudiantes WHERE dni like :dnie")
    LiveData<Estudiante> CogerEstudiante(String dnie);
}
