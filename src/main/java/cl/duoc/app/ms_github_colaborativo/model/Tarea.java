package cl.duoc.app.ms_github_colaborativo.model;

public class Tarea {

    private Long id;
    private String titulo;
    private String descripcion;
    private String responsable;
    private boolean completada;

    public Tarea() {
    }

    public Tarea(Long id, String titulo, String descripcion, String responsable, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.completada = completada;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}