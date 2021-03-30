package application;

import xadrez.PartidaXadrez;

public class Principal {

	public static void main(String[] args) {
		
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		UI.printTabuleiro(partidaXadrez.getPecas());

	}

}
