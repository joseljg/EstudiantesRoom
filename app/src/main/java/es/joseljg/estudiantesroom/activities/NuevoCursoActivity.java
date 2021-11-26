package es.joseljg.estudiantesroom.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.joseljg.estudiantesroom.R;
import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.viewmodel.CursoViewModel;

public class NuevoCursoActivity extends AppCompatActivity {

    private EditText edt_add_curso;
    private EditText edt_add_descripcion;
    CursoViewModel mCursoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_curso);
        edt_add_curso = (EditText) findViewById(R.id.edt_add_curso);
        edt_add_descripcion = (EditText) findViewById(R.id.edt_add_descripcion);
        mCursoViewModel = new ViewModelProvider(this).get(CursoViewModel.class);

    }

    public void add_curso(View view) {
        String nombrec = String.valueOf(edt_add_curso.getText());
        String descripcionc = String.valueOf(edt_add_descripcion.getText());
        boolean error = false;
        if(nombrec.isEmpty())
        {
            edt_add_curso.setError("escribe algo en el nombre del curso");
            error = true;
        }
        if(descripcionc.isEmpty())
        {
            edt_add_descripcion.setError("escribe algo en la descripcion del curso");
            error = true;
        }
        if(error)
        {
            return;
        }
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("guardar el curso?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Curso c = new Curso(nombrec, descripcionc);
                boolean insercionOK = mCursoViewModel.insertarCurso(c);
                mostrarToast(insercionOK);
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }

    public void mostrarToast(boolean insercionOK)
    {
        if(insercionOK)
        {
            Toast.makeText(this,"curso guardada correctamente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"No se pudo guardar el curso", Toast.LENGTH_SHORT).show();
        }
    }
}