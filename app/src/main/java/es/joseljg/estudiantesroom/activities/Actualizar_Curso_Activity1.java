package es.joseljg.estudiantesroom.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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

public class Actualizar_Curso_Activity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_CURSO = "es.joseljg.actualizarcurso1.objeto_curso";
    private Spinner sp_actualizarc = null;
    CursoViewModel mCursoViewModel = null;
    static Curso cseleccionado = null;
    static ArrayAdapter<Curso> adapter = null;
    LiveData<List<Curso>> cursos = null;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_curso1);
        setContentView(R.layout.activity_actualizar_curso1);
        sp_actualizarc = (Spinner) findViewById(R.id.sp_actualizarc);
        sp_actualizarc.setOnItemSelectedListener(this);
        // mProvinciaViewModel = ViewModelProviders.of(this).get(ProvinciaViewModel.class);
        mCursoViewModel = new ViewModelProvider(this).get(CursoViewModel.class);

        //-----------------------------------------------------------
        LiveData<List<Curso>> cursosLive = mCursoViewModel.obtenercursos();
        if(cursosLive != null) {
            cursosLive.observe(this, new Observer<List<Curso>>() {
                @Override
                public void onChanged(@Nullable final List<Curso> loscursos) {
                    asignarAdaptadorSpinnerProvincias(loscursos);
                }
            });
        }
        else{
            Toast.makeText(this, "no se han recuperado provincias", Toast.LENGTH_SHORT).show();
        }
    }

    private void asignarAdaptadorSpinnerProvincias(List<Curso> lasprovincias) {
        adapter = new ArrayAdapter<Curso>(this , R.layout.item_curso, lasprovincias);
        sp_actualizarc.setAdapter(adapter);
    }

    public void siguienteactualizarProvincia(View view) {
        if(cseleccionado == null)
        {
            mostrarToast("selecciona una provincia");
            return;
        }

        Intent intent = new Intent(this, Actualizar_curso_Activity2.class);
        intent.putExtra(EXTRA_OBJETO_CURSO, cseleccionado);
        // Toast.makeText(this,"la provincia seleccionada es " +pseleccionada.getNombre(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Curso c = (Curso) sp_actualizarc.getItemAtPosition(position);
        cseleccionado = c;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void siguienteactualizarprovincia1(View view) {
        if(cseleccionado == null)
        {
            mostrarToast("selecciona un curso");
            return;
        }

        Intent intent = new Intent(this, Actualizar_curso_Activity2.class);
        intent.putExtra(EXTRA_OBJETO_CURSO, cseleccionado);
        // Toast.makeText(this,"la provincia seleccionada es " +pseleccionada.getNombre(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}