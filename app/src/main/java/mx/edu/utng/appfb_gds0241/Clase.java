package mx.edu.utng.appfb_gds0241;

public class Clase {
    private String claseId, seccion, area, tema;

    public Clase(String claseId, String seccion, String area, String tema) {
        this.claseId = claseId;
        this.seccion = seccion;
        this.area = area;
        this.tema = tema;
    }

    public String getClaseId() {
        return claseId;
    }

    public void setClaseId(String claseId) {
        this.claseId = claseId;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
