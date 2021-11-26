package es.joseljg.estudiantesroom.activities;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.R;

public class ListaCursosAdapter extends RecyclerView.Adapter<CursoViewHolder>{
    private Context c;
    private List<Curso>  listaCursos;
    private LayoutInflater mInflater;

    public void setC(Context c) {
        this.c = c;
        this.listaCursos = new ArrayList<Curso>();
    }
    public ListaCursosAdapter(Context c, List<Curso> listaCursos) {
        this.c = c;
        this.listaCursos = listaCursos;
        mInflater = LayoutInflater.from(c);
    }

    public Context getC() {
        return c;
    }



    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
      /*  if(this.listaCursos == null)
        {
            Log.i("cursos","la lista cursos es nulo");
        }
        else{
            for(Curso c:listaCursos)
            {
                Log.i("cursos","curso -> " + c.getCurso());
            }
        }
        */
        notifyDataSetChanged();
    }

    public ListaCursosAdapter(Context c) {
        this.c = c;
        mInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public CursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_curso, parent, false);
        return new CursoViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CursoViewHolder holder, int position) {
        if(listaCursos!=null) {
            Curso curso_actual = listaCursos.get(position);
            holder.txt_rv_curso_nombrec.setText("Curso: " + curso_actual.getCurso());
            holder.txt_rv_curso_descripcion.setText(String.valueOf("descripcion: " + curso_actual.getDescripcion()));
        }
    }

    @Override
    public int getItemCount() {
        if (listaCursos != null)
            return listaCursos.size();
        else return 0;
    }
}
