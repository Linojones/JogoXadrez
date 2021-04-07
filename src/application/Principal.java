package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> capturada = new ArrayList<>();
		
		while (!partidaXadrez.getCheckMate()) {
			
			try {
				UI.limpaTela();
				UI.imprimePartida(partidaXadrez, capturada);
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
				UI.limpaTela();
				UI.imprimeTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				
				PecaXadrez pecaCapturada = partidaXadrez.executaMovimento(origem, destino);
				if(pecaCapturada != null) {
					capturada.add(pecaCapturada);
				}
				
				if (partidaXadrez.getPromocao() != null) {
					System.out.print("Digite a peça Promovida (B/C/Q/T): ");
					String tipo = sc.nextLine().toUpperCase();
					while (!tipo.equals("B") && !tipo.equals("C") && !tipo.equals("Q") && !tipo.equals("T")) {
						System.out.println("Valor invalido! Digite a peça Promovida (B/C/Q/T): ");
						tipo = sc.nextLine().toUpperCase();
					}
					partidaXadrez.substituirPecaPromovida(tipo);
				}
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
		UI.limpaTela();
		UI.imprimePartida(partidaXadrez, capturada);

	}

}