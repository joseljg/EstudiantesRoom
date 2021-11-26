package es.joseljg.estudiantesroom.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import es.joseljg.estudiantesroom.R;
import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.viewmodel.CursoViewModel;

public class MostrarCursoActivity extends AppCompatActivity {

    private RecyclerView rv_cursos;
    private ListaCursosAdapter mAdapter;
    private List<Curso> cursos;
    CursoViewModel mCursoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_curso);
        rv_cursos = findViewById(R.id.rv_cursos);
        //----------------------------------------------------------------------------
        // mCiudadViewModel = ViewModelProviders.of(this).get(CiudadViewModel.class);
        mCursoViewModel = new ViewModelProvider(this).get(CursoViewModel.class);

        //-----------------------------------------------------------
        mAdapter = new ListaCursosAdapter(this);
        //-----------------------------------------------------------
        mCursoViewModel = new ViewModelProvider(this).get(CursoViewModel.class);
        LiveData<List<Curso>> cursosLive = mCursoViewModel.obtenercursos();
        if(cursosLive != null) {
            cursosLive.observe(this, new Observer<List<Curso>>() {
                @Override
                public void onChanged(@Nullable final List<Curso> loscursos) {
                    // Update the cached copy of the words in the adapter.
                    cursos = loscursos;
                    mAdapter.setListaCursos(loscursos);
                }
            });
        }
        //------------------------------------------------------------
        rv_cursos.setAdapter(mAdapter);
        rv_cursos.setLayoutManager(new LinearLayoutManager(this));
        //------------------------------------------------------------

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(cursos, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    mostrarToast("ha pulsado izquierda");
                    // Curso c = curso.get(viewHolder.getAdapterPosition());
                    // CursoController.borrarCurso(c);
                    cursos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    cursos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_cursos);
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

}