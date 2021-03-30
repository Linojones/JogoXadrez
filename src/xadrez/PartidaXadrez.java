package xadrez;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Peao;
import xadrez.pecas.Rainha;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		configInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
			}
		}
		return mat;
	}
	
	private void configInicial() {
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(0,0));
		tabuleiro.colocarPeca(new Cavalo(tabuleiro, Cor.BRANCO), new Posicao(0,1));
		tabuleiro.colocarPeca(new Bispo(tabuleiro, Cor.BRANCO), new Posicao(0,2));
		tabuleiro.colocarPeca(new Rainha(tabuleiro, Cor.BRANCO), new Posicao(0,3));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(0,4));
		tabuleiro.colocarPeca(new Bispo(tabuleiro, Cor.BRANCO), new Posicao(0,5));
		tabuleiro.colocarPeca(new Cavalo(tabuleiro, Cor.BRANCO), new Posicao(0,6));
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(0,7));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,0));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,1));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,2));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,3));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,4));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,5));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,6));
		tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(1,7));
		
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(7,4));
	}

}