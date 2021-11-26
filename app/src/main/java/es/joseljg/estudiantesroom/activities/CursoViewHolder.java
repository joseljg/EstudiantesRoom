package es.joseljg.estudiantesroom.activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import es.joseljg.estudiantesroom.R;
import es.joseljg.estudiantesroom.clases.Curso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CursoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final String EXTRA_OBJETO_CURSO =  "es.joseljg.cursoViewHolder.objeto_curso";
    public TextView txt_rv_curso_nombrec = null;
    public TextView txt_rv_curso_descripcion = null;
    ListaCursosAdapter lcAdapter;

    public CursoViewHolder(@NonNull View itemView, ListaCursosAdapter lcAdapter) {
        super(itemView);
        txt_rv_curso_nombrec = (TextView)  itemView.findViewById(R.id.txt_rv_curso_nombrec);
        txt_rv_curso_descripcion = (TextView)  itemView.findViewById(R.id.txt_rv_curso_descripcion);
        this.lcAdapter = lcAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mPosition = getAdapterPosition();
        // int mPosition = getLayoutPosition();
        List<Curso> cursos = this.lcAdapter.getListaCursos();
        Curso curso = cursos.get(mPosition);
        // lcAdapter.notifyDataSetChanged();
        Intent intent = new Intent(lcAdapter.getC(), MostrarDetallesCursoActivity.class);
        intent.putExtra(EXTRA_OBJETO_CURSO, curso);
        lcAdapter.getC().startActivity(intent);
    }
}
