package dad.javaspace.launchermodel;

import dad.javaspace.interfacing.ScreenResolutions;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LauncherModel {
	private DoubleProperty volumenMusica;
	private DoubleProperty volumenJuego;
	private IntegerProperty numPlayers;
	private StringProperty ip;
	private IntegerProperty puerto;
	private IntegerProperty selectedSkin;
	private StringProperty nombreJugador;
	private BooleanProperty pantallaCompleta;
	private ObjectProperty<ScreenResolutions> resolucion;

	public LauncherModel() {
		volumenMusica = new SimpleDoubleProperty(this, "volumenMusica", 1.0);
		volumenJuego = new SimpleDoubleProperty(this, "volumenMusica", 1.0);
		numPlayers = new SimpleIntegerProperty(this, "numPlayers", 1);
		ip = new SimpleStringProperty(this, "ip");
		puerto = new SimpleIntegerProperty(this, "puerto", 2000);
		selectedSkin = new SimpleIntegerProperty(this, "selectedSkin", 0);
		nombreJugador = new SimpleStringProperty(this, "nombreJugador", "DefaultPlayerName");
		pantallaCompleta = new SimpleBooleanProperty(this, "pantallaCompleta", true);
		resolucion = new SimpleObjectProperty<>(this, "resolucion");

		numPlayersProperty().addListener((o, ov, nv) -> {
			System.out.println("hola!");
			String texto = String.valueOf(getNumPlayers());
			
			Integer.parseInt(texto);
		});
	}

	public final DoubleProperty volumenMusicaProperty() {
		return this.volumenMusica;
	}

	public final double getVolumenMusica() {
		return this.volumenMusicaProperty().get();
	}

	public final void setVolumenMusica(final double volumenMusica) {
		this.volumenMusicaProperty().set(volumenMusica);
	}

	public final DoubleProperty volumenJuegoProperty() {
		return this.volumenJuego;
	}

	public final double getVolumenJuego() {
		return this.volumenJuegoProperty().get();
	}

	public final void setVolumenJuego(final double volumenJuego) {
		this.volumenJuegoProperty().set(volumenJuego);
	}

	public final StringProperty ipProperty() {
		return this.ip;
	}

	public final String getIp() {
		return this.ipProperty().get();
	}

	public final void setIp(final String ip) {
		this.ipProperty().set(ip);
	}

	public final IntegerProperty puertoProperty() {
		return this.puerto;
	}

	public final int getPuerto() {
		return this.puertoProperty().get();
	}

	public final void setPuerto(final int puerto) {
		this.puertoProperty().set(puerto);
	}

	public final StringProperty nombreJugadorProperty() {
		return this.nombreJugador;
	}

	public final String getNombreJugador() {
		return this.nombreJugadorProperty().get();
	}

	public final void setNombreJugador(final String nombreJugador) {
		this.nombreJugadorProperty().set(nombreJugador);
	}

	public final BooleanProperty pantallaCompletaProperty() {
		return this.pantallaCompleta;
	}

	public final boolean isPantallaCompleta() {
		return this.pantallaCompletaProperty().get();
	}

	public final void setPantallaCompleta(final boolean pantallaCompleta) {
		this.pantallaCompletaProperty().set(pantallaCompleta);
	}

	public final ObjectProperty<ScreenResolutions> resolucionProperty() {
		return this.resolucion;
	}

	public final ScreenResolutions getResolucion() {
		return this.resolucionProperty().get();
	}

	public final void setResolucion(final ScreenResolutions resolucion) {
		this.resolucionProperty().set(resolucion);
	}

	public final IntegerProperty selectedSkinProperty() {
		return this.selectedSkin;
	}

	public final int getSelectedSkin() {
		return this.selectedSkinProperty().get();
	}

	public final void setSelectedSkin(final int selectedSkin) {
		this.selectedSkinProperty().set(selectedSkin);
	}

	public final IntegerProperty numPlayersProperty() {
		return this.numPlayers;
	}

	public final int getNumPlayers() {
		return this.numPlayersProperty().get();
	}

	public final void setNumPlayers(final int numPlayers) {
		this.numPlayersProperty().set(numPlayers);
	}

}
