package es.joseljg.estudiantesroom.roomDatabase;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.joseljg.estudiantesroom.clases.Estudiante;
import es.joseljg.estudiantesroom.dao.DAOEstudiante;
import es.joseljg.estudiantesroom.clases.Curso;
import es.joseljg.estudiantesroom.dao.DAOCurso;


@Database(entities = {Curso.class, Estudiante.class}, version = 1, exportSchema = false)
public  abstract class InstitutoRoomDatabase extends RoomDatabase {
    public abstract DAOEstudiante EstudianteDAO();
    public abstract DAOCurso cursoDAO();
    private static InstitutoRoomDatabase INSTANCE;

    public static InstitutoRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (InstitutoRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            InstitutoRoomDatabase.class, "instituto_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}