package xadrez.pecas;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rainha extends PecaXadrez{

	public Rainha(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	
	@Override
	public boolean[][] movimentosPossiveis() {
boolean[][] mat = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao (0,0);
		
		// Acima
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		// Abaixo
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		// Esquerda
		p.definirValores(posicao.getLinha(), posicao.getColuna() - 1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		// Direita
		p.definirValores(posicao.getLinha(), posicao.getColuna() + 1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		// Noroeste
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() - 1, p.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		// Nordeste
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() - 1, p.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		// Sudeste
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() + 1, p.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		// Sudoeste
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() + 1, p.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPecaOponente(p)) {
			mat [p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "Q";
	}

}
