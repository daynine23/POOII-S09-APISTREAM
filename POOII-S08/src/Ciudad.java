public class Ciudad {
    private int idCiudad;
    private String nombreCiudad;
    private int nroPoblacion;
    private String codCiudad;

    public Ciudad(int idCiudad, String nombreCiudad, int nroPoblacion, String codCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.nroPoblacion = nroPoblacion;
        this.codCiudad = codCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public void setNroPoblacion(int nroPoblacion) {
        this.nroPoblacion = nroPoblacion;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }
}
