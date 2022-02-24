package dad.virus.reports;

import java.util.Date;

/**
 * Clase Result
 */
public class Result {
    private String tiempoJugado;
    private Date fechaPartida;
    private int nTiradas;

    /**
     * Instantiates a new Resultado.
     *
     * @param tiempoJugado el tiempo jugado
     * @param fechaPartida la fecha de partida
     */
    public Result(String tiempoJugado, Date fechaPartida, int nTiradas) {
        this.tiempoJugado = tiempoJugado;
        this.fechaPartida = fechaPartida;
        this.nTiradas = nTiradas;
    }

    public String getTiempoJugado() {
        return tiempoJugado;
    }

    public Date getFechaPartida() {
        return fechaPartida;
    }

    public int getnTiradas() {
        return nTiradas;
    }
}
