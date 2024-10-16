import java.util.List;

public class Pais {
    private String codPais;
    private String nombrePais;
    private String nombreContinente;
    private double areaPoblacion;
    private int capital;
    private int nroPoblacion;
    List<Ciudad> ciudades;

    public Pais(String codPais, String nombrePais, String nombreContinente, double areaPoblacion, int capital, int nroPoblacion, List<Ciudad> ciudades) {
        this.codPais = codPais;
        this.nombrePais = nombrePais;
        this.nombreContinente = nombreContinente;
        this.areaPoblacion = areaPoblacion;
        this.capital = capital;
        this.nroPoblacion = nroPoblacion;
        this.ciudades = ciudades;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    public double getAreaPoblacion() {
        return areaPoblacion;
    }

    public void setAreaPoblacion(double areaPoblacion) {
        this.areaPoblacion = areaPoblacion;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public void setNroPoblacion(int nroPoblacion) {
        this.nroPoblacion = nroPoblacion;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
