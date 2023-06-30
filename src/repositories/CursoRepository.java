package src.repositories;

import java.util.ArrayList;
import java.util.List;

import src.entities.CursoEntity;

public class CursoRepository {

    private static CursoRepository instance;

    private List<CursoEntity> cursos;

    private CursoRepository() {
        this.cursos = new ArrayList<CursoEntity>();
    }

    public static CursoRepository getInstance() {
        if (instance == null) {
            instance = new CursoRepository();
        }

        return instance;
    }

}
