package es.joseljg.estudiantesroom.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.repositories.CursoRepository;

public class CursoViewModel extends AndroidViewModel {
    private CursoRepository mRepository;
    private LiveData<List<Curso>> mAllCursos;
    public CursoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CursoRepository(application);
        mAllCursos = mRepository.getAllCursos();
    }

    public LiveData<List<Curso>> obtenercursos()
    {
        LiveData<List<Curso>> mAllCursos = mRepository.getAllCursos();
        return mAllCursos;
    }

    public boolean insertarCurso(Curso c)
    {
        boolean insercionOK = mRepository.insertarCurso(c);
        return insercionOK;
    }

    public boolean borrarCurso(Curso c)
    {
        boolean borradoOK = mRepository.borrarCurso(c);
        return borradoOK;
    }

    public  boolean actualizarCurso(Curso c)
    {
        boolean actualizacionOK = mRepository.actualizarCurso(c);
        return actualizacionOK;
    }

}
