package es.joseljg.estudiantesroom.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import es.joseljg.estudiantesroom.R;
import es.joseljg.estudiantesroom.clases.Curso;

public class MostrarDetallesCursoActivity extends AppCompatActivity {

    TextView txt_detalle_cursoc = null;
    TextView txt_detalle_descripcionc = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_curso);
        txt_detalle_cursoc = findViewById(R.id.txt_detalle_nombrec);
        txt_detalle_descripcionc = findViewById(R.id.txt_detalle_descripcionc);
        Intent intent = getIntent();
        if(intent != null)
        {
            Curso c = (Curso) intent.getSerializableExtra(CursoViewHolder.EXTRA_OBJETO_CURSO);
            txt_detalle_cursoc.setText(c.getCurso());
            txt_detalle_cursoc.setText("cursos: " + String.valueOf(c.getCurso()));
            txt_detalle_descripcionc.setText("descripcion: " + String.valueOf(c.getDescripcion()));
        }
    }
}