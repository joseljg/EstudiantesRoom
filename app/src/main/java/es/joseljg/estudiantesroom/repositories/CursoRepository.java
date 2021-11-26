package es.joseljg.estudiantesroom.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import es.joseljg.estudiantesroom.dao.DAOCurso;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.repositories.tareas.TareaActualizarCurso;
import es.joseljg.estudiantesroom.repositories.tareas.TareaBorrarCurso;
import es.joseljg.estudiantesroom.repositories.tareas.TareaInsertarCurso;
import es.joseljg.estudiantesroom.repositories.tareas.TareaObtenerCursos;
import es.joseljg.estudiantesroom.roomDatabase.InstitutoRoomDatabase;

@SuppressWarnings("unchecked")
public class CursoRepository {

    public static DAOCurso mcursoDao;
    private LiveData<List<Curso>> mAllcursos;

    public CursoRepository(Application application) {
        InstitutoRoomDatabase db = InstitutoRoomDatabase.getDatabase(application);
        mcursoDao = db.cursoDAO();
        mAllcursos= mcursoDao.cogerTodosLosCursos();
    }

    public LiveData<List<Curso>> getAllCursos() {
        return mAllcursos;
    }
//--------------------------------------------------------------------------------------------
public static boolean insertarCurso(Curso c) {
    FutureTask t = new FutureTask(new TareaInsertarCurso(c));
    ExecutorService es = Executors.newSingleThreadExecutor();
    es.submit(t);
    boolean insercionOK = false;
    try {
        insercionOK = (boolean) t.get();
        es.shutdown();
        try {
            if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                es.shutdownNow();
            }
        } catch (InterruptedException e) {
            es.shutdownNow();
        }
    } catch (
            ExecutionException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    finally {
        return insercionOK;
    }
}

    //---------------------------------------------------------------------------

    public static LiveData<List<Curso>> obtenerCursos()
    {
        LiveData<List<Curso>> cursosDevueltos = null;
        FutureTask t = new FutureTask (new TareaObtenerCursos());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            cursosDevueltos= (LiveData<List<Curso>>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cursosDevueltos;
    }
    //---------------------------------------------------------------------------
    public static boolean   borrarCurso(Curso c) {
        FutureTask t = new FutureTask(new TareaBorrarCurso(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }
    //---------------------------------------------------------------------------

    public static boolean actualizarCurso(Curso c) {
        FutureTask t = new FutureTask(new TareaActualizarCurso(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }

    //-----------------------------------------------------------------------------------------


}
