package es.joseljg.estudiantesroom.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.joseljg.estudiantesroom.clases.Curso;


@Dao
public interface DAOCurso {

    @Insert
    void insert(Curso curso);

    @Delete
    void delete(Curso curso);

    @Query("DELETE FROM cursos")
    void deleteAll();

    @Update
    void update(Curso curso);

    @Query("SELECT * from cursos ORDER BY curso ASC")
    LiveData<List<Curso>> cogerTodosLosCursos();


    @Query("SELECT * FROM cursos WHERE curso like :curso")
    LiveData<Curso> CogerCurso(String curso);

}
