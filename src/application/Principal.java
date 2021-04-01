package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while (true) {
			
			try {
				UI.limpaTela();
				UI.printTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				
				PecaXadrez pecaCapturada = partidaXadrez.executaMovimento(origem, destino);
			}
			catch(ExcecaoXadrez e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			// Os catch's acima, estao tratando os possiveis erros e nao so avisando que eles ocorreram
			}
		}

	}

}