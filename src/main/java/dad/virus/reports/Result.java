package dad.virus.reports;

import java.util.Date;

/**
 * The type Resultado.
 */
public class Result {
    private String tiempoJugado;
    private Date fechaPartida;

    /**
     * Instantiates a new Resultado.
     *
     * @param tiempoJugado the tiempo jugado
     * @param fechaPartida the fecha partida
     */
    public Result(String tiempoJugado, Date fechaPartida) {
        this.tiempoJugado = tiempoJugado;
        this.fechaPartida = fechaPartida;
    }

    public String getTiempoJugado() {
        return tiempoJugado;
    }

    public Date getFechaPartida() {
        return fechaPartida;
    }
}
