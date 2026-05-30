package cl.duoc.app.ms_github_colaborativo.service;

import cl.duoc.app.ms_github_colaborativo.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final List<Tarea> tareas = new ArrayList<>();
    private Long contadorId = 1L;

    public TareaService() {
        tareas.add(new Tarea(contadorId++, "Crear repositorio", "Crear el proyecto base en GitHub", "Alumno 1", false));
        tareas.add(new Tarea(contadorId++, "Crear modelo", "Crear clase Tarea", "Alumno 2", false));
        tareas.add(new Tarea(contadorId++, "Crear controlador", "Crear endpoints REST", "Alumno 3", false));
    }

    public List<Tarea> listar() {
        return tareas;
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Tarea crear(Tarea tarea) {
        tarea.setId(contadorId++);
        tareas.add(tarea);
        return tarea;
    }

    public Optional<Tarea> actualizar(Long id, Tarea tareaActualizada) {
        return buscarPorId(id).map(tarea -> {
            tarea.setTitulo(tareaActualizada.getTitulo());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setResponsable(tareaActualizada.getResponsable());
            tarea.setCompletada(tareaActualizada.isCompletada());
            return tarea;
        });
    }

    public boolean eliminar(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}