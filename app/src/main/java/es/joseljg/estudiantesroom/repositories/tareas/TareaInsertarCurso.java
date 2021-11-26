package es.joseljg.estudiantesroom.repositories.tareas;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.repositories.CursoRepository;

public class TareaInsertarCurso implements Callable<Boolean> {
    private Curso c = null;

    public TareaInsertarCurso(Curso c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            CursoRepository.mcursoDao.insert(c);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
