package xadrez;

import java.util.ArrayList;
import java.util.List;

import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Peao;
import xadrez.pecas.Rainha;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		configInicial();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Cor getJogadorAtual() {
		return jogadorAtual;
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
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez sourcePosicao){
		Posicao posicao = sourcePosicao.toPosicao();
		validaPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	public PecaXadrez executaMovimento(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validaPosicaoOrigem(origem);
		validaPosicaoDestino(origem, destino);
		Peca pecaCapturada = fazerMovimento(origem, destino);
		proximoTurno();
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca fazerMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.colocarPeca(p, destino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		return pecaCapturada;
	}
	
	private void validaPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new ExcecaoXadrez("Não há peça na posição de origem");
		}
		if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()) {
			throw new ExcecaoXadrez("A peça escolhida não é sua!");
		}
		if (!tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new ExcecaoXadrez("Não há movimentos possíveis para a peça escolhida");
		}
	}
	
	private void validaPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new ExcecaoXadrez("A peça escolhida não pode se mover ate a casa destino");
		}
	}
	
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	// Colocando uma peça usando as coordenadas do xadrez (A1) e nao da matriz (0,0)
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
		pecasNoTabuleiro.add(peca);
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
		
		// forma antiga de add pecas ao tabuleiro
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(7,3));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(7,4));
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(7,5));
	}

}