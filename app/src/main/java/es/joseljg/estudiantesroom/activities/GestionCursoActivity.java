package es.joseljg.estudiantesroom.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.joseljg.estudiantesroom.R;

public class GestionCursoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_curso);
    }

    public void add_curso(View view) {
        Intent intent = new Intent(this, NuevoCursoActivity.class);
        startActivity(intent);
    }

    public void mostrarCurso(View view) {
        Intent intent = new Intent(this, MostrarCursoActivity.class);
        startActivity(intent);
    }

    public void borrarCurso(View view) {
        Intent intent = new Intent(this, BorrarCursoActivity.class);
        startActivity(intent);
    }

    public void actualizar_curso(View view) {
        Intent intent = new Intent(this, Actualizar_Curso_Activity1.class);
        startActivity(intent);
    }
}