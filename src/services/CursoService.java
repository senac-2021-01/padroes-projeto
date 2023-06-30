package src.services;

import src.repositories.CursoRepository;

public class CursoService {

    private static CursoService instance;

    private CursoRepository cursoRepository;

    private CursoService() {
        this.cursoRepository = CursoRepository.getInstance();
    }

    public static CursoService getInstance() {
        if (instance == null) {
            instance = new CursoService();
        }

        return instance;
    }

}
