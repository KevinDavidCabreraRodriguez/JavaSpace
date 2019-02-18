package dad.javaspace;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import dad.javaspace.networking.NetworkingPlayer;

public class ClientConnectionThread extends Thread {

	private Scanner scanner;
	private OutputStreamWriter writer;
	ClientModel model;

	public ClientConnectionThread(Scanner sc, ClientModel model, OutputStreamWriter out) {
		scanner = sc;
		this.model = model;
		this.writer = out;
	}

	@Override
	public void run() {
		super.run();

		System.out.println(scanner.nextLine());
		System.out.println("Thread conexiones up");

		while (true) {
			try {
				sendPlayerPosition();
				desempaquetarPosiciones(scanner.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void desempaquetarPosiciones(String paquete) {
		String[] buffer = paquete.split("_").clone();
		int id = 0;
		for (String str : buffer) {
			id = Integer.parseInt(str.split(",")[0].toString());
			if (id != model.getIdentity()) {
				NetworkingPlayer bufferPlayer = find(id);
				bufferPlayer.getEntity().setX(Double.parseDouble(str.split(",")[1].toString()));
				bufferPlayer.getEntity().setY(Double.parseDouble(str.split(",")[2].toString()));
				bufferPlayer.getEntity().setRotation(Double.parseDouble(str.split(",")[3].toString()));
			}
		}
	}

	private void sendPlayerPosition() {
		try {
			String paquete =Math.round(model.getPlayerX()) +","+ Math.round(model.getPlayerY()) +"," + Math.round(model.getAngular());
			System.out.println(paquete);
			if (model.isCanShoot()) {
				model.setCanShoot(false);

				writer.write(paquete +","+ true + "\n");
			} else
				writer.write(paquete +","+ false + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private NetworkingPlayer find(int id) {

		for (NetworkingPlayer player : model.getJugadores()) {
			if (player.getId() == id)
				return player;
		}

		return null;
	}
}
