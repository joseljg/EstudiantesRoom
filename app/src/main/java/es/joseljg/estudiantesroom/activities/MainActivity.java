package es.joseljg.estudiantesroom.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.joseljg.estudiantesroom.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gestionar_cursos(View view) {
        Intent intent = new Intent(this, GestionCursoActivity.class);
        startActivity(intent);
    }

    public void gestionar_estudiantes(View view) {
    }
}