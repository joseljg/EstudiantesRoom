package es.joseljg.estudiantesroom.repositories.tareas;

import androidx.lifecycle.LiveData;

import java.util.List;

import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.repositories.CursoRepository;

import java.util.concurrent.Callable;

public class TareaObtenerCursos implements Callable <LiveData<List<Curso>>> {


    @Override
    public LiveData<List<Curso>> call() throws Exception {
        try{
            LiveData<List<Curso>> cursos = CursoRepository.mcursoDao.cogerTodosLosCursos();
            return cursos;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
