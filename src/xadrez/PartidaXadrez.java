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
	
	// Colocando uma peça usando as coordenadas do xadrez (A1) e nao da matriz (0,0)
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void configInicial() {
		colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 8, new Rainha(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('a', 7, new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('b', 7, new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('c', 7, new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 7, new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 7, new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('f', 7, new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('g', 7, new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('h', 7, new Peao(tabuleiro, Cor.BRANCO));
		
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(7,4));
	}

}