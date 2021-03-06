package uff.ic.lleme.tic10002.aulas.listas.implementacoes;

import uff.ic.lleme.tic10002.aulas.listas.interfaces.Lista;
import uff.ic.lleme.tic10002.aulas.utils.Conteudo;

public class ListaEstaticaCircularNaoOrdenadaDeObjetos implements Lista {

    private final int delta = 100;
    private int tamanho = 0;
    private int inicio = 0;
    private int fim = 0;
    private Conteudo[] lista = new Conteudo[delta];

    private void incInicio() {
        inicio = ++inicio % lista.length;
    }

    private void incFim() {
        fim = ++fim % lista.length;
    }

    private void expandir() {
        int fim = this.fim;
        if (fim < inicio)
            fim = fim + lista.length;

        Conteudo[] lista = new Conteudo[this.lista.length + delta];
        int l = 0;
        for (int k = inicio; k < fim + 1; k++)
            lista[l++] = this.lista[k % this.lista.length];
        this.lista = lista;
        this.inicio = 0;
        this.fim = tamanho;
    }

    private void reduzir() {

    }

    @Override
    public Conteudo buscar(int chave) {
        int fim = this.fim;
        if (fim < inicio)
            fim = fim + lista.length;

        return buscar(chave, inicio, fim);
    }

    private Conteudo buscar(int chave, int i, int j) {
        int meio = (i + j) / 2;
        int meio_ = meio % lista.length;

        if (lista[meio_].chaveAsNum() == chave)
            return lista[meio_];
        else if (chave < lista[meio_].chaveAsNum())
            return buscar(chave, i, meio - 1);
        else if (chave > lista[meio_].chaveAsNum())
            return buscar(chave, meio + 1, j);
        else
            return null;
    }

    @Override
    public Conteudo obter(int pos) {
        return lista[(inicio + pos) % lista.length];
    }

    @Override
    public void incluir(Conteudo objeto) {
        if (tamanho == lista.length)
            expandir();
        lista[fim] = objeto;
        incFim();
        tamanho++;
    }

    @Override
    public void excluir(int posicao) {
        // TODO Para casa
    }

}
