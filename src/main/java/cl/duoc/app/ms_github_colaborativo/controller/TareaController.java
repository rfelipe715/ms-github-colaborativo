package cl.duoc.app.ms_github_colaborativo.controller;


import cl.duoc.app.ms_github_colaborativo.model.Tarea;
import cl.duoc.app.ms_github_colaborativo.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/saludo")
    public String saludo() {
        return "Microservicio colaborativo funcionando correctamente";
    }

    @GetMapping
    public List<Tarea> listar() {
        return tareaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> buscarPorId(@PathVariable Long id) {
        return tareaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaService.crear(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.actualizar(id, tarea)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (tareaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}