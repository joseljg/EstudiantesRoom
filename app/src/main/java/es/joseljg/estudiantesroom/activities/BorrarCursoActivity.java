package es.joseljg.estudiantesroom.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import es.joseljg.estudiantesroom.R;
import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.viewmodel.CursoViewModel;

public class BorrarCursoActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    Spinner sp_borrar_curso = null;
    Curso cseleccionado = null;
    ArrayAdapter<Curso> adapter = null;
    CursoViewModel mCursoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_curso);
        sp_borrar_curso = (Spinner) findViewById(R.id.sp_borrar_curso);
        sp_borrar_curso.setOnItemSelectedListener(this);
        // mProvinciaViewModel = ViewModelProviders.of(this).get(ProvinciaViewModel.class);
        mCursoViewModel = new ViewModelProvider(this).get(CursoViewModel.class);
        //-----------------------------------------------------------
        LiveData<List<Curso>> cursosLive = mCursoViewModel.obtenercursos();
        if(cursosLive != null) {
            cursosLive.observe(this, new Observer<List<Curso>>() {
                @Override
                public void onChanged(@Nullable final List<Curso> loscursos) {
                    asignarAdaptadorSpinnerCursos(loscursos);
                }
            });
        }
        else{
            Toast.makeText(this, "no se han recuperado provincias", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void asignarAdaptadorSpinnerCursos(List<Curso> los_cursos) {
        adapter = new ArrayAdapter<Curso>(this , R.layout.item_curso, los_cursos);
        sp_borrar_curso.setAdapter(adapter);
    }

    public void borrarCurso(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("De verdad quieres borrar el curso?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cseleccionado == null)
                {
                    mostrarToast("selecciona un curso");
                    return;
                }
                //borrar provincia
                boolean borradoOK = mCursoViewModel.borrarCurso(cseleccionado);
                if(borradoOK)
                {
                    mostrarToast("curso borrado correctamente");
                }
                else{
                    mostrarToast("el curso no se pudo borrar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Curso c = (Curso) sp_borrar_curso.getItemAtPosition(position);
        cseleccionado = c;
        //  Toast.makeText(this, p.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}