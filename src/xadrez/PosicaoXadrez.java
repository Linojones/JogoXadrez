package xadrez;

import jogoTabuleiro.Posicao;

public class PosicaoXadrez {
	
	private char coluna;
	private int linha;
	
	public PosicaoXadrez(char coluna, int linha) {
		
		// Programação defensiva, testando os valores possiveis para evitar posicoes fora do intervalo do tabuleiro
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new ExcecaoXadrez("Erro de instaciação, valores validos a1 ate h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	public char getColuna() {
		return coluna;
	}
	public int getLinha() {
		return linha;
	}
	
	protected Posicao toPosicao() {
		// 8 - linha(8) = (0) && coluna -coluna(a) - unicode(a) = (0) >>> valor na matriz [0][0] 
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PosicaoXadrez fromPosicao(Posicao posicao) {
		return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		
		// Colocar um string vazio é uma forma de burlar o compilador para concatenar strings
		return "" + coluna + linha;
	}

}
