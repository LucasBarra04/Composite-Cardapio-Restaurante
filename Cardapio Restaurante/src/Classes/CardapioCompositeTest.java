package Classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardapioCompositeTest {

    private Prato criarPrato(String descricao, double preco) {
        Prato p = new Prato();
        p.setDescricao(descricao);
        p.setPreco(preco);
        return p;
    }

    private Categoria criarCategoria(String descricao) {
        Categoria c = new Categoria();
        c.setDescricao(descricao);
        return c;
    }

    @Test
    void pratoDeveRetornarDescricaoEPrecoNoConteudo() {
        Prato p = criarPrato("Picanha grelhada", 89.90);
        assertTrue(p.getConteudo().contains("Picanha grelhada"));
        assertTrue(p.getConteudo().contains("89.9"));
    }

    @Test
    void pratoDeveEstenderItemCardapio() {
        assertTrue(criarPrato("Pudim", 16.0) instanceof ItemCardapio);
    }

    @Test
    void categoriaDeveConterDescricaoNoConteudo() {
        Categoria c = criarCategoria("Entradas");
        assertTrue(c.getConteudo().contains("Entradas"));
    }

    @Test
    void categoriaDeveExibirPratosAdicionados() {
        Categoria c = criarCategoria("Entradas");
        c.addItem(criarPrato("Bruschetta", 18.90));
        c.addItem(criarPrato("Bolinha de queijo", 22.50));

        String conteudo = c.getConteudo();
        assertTrue(conteudo.contains("Bruschetta"));
        assertTrue(conteudo.contains("Bolinha de queijo"));
    }

    @Test
    void categoriaDeveAceitarOutraCategoriaComoItem() {
        Categoria bebidas = criarCategoria("Bebidas");
        bebidas.addItem(criarPrato("Suco", 12.0));

        Categoria raiz = criarCategoria("Cardápio");
        raiz.addItem(bebidas);

        assertTrue(raiz.getConteudo().contains("Bebidas"));
        assertTrue(raiz.getConteudo().contains("Suco"));
    }

    @Test
    void cardapioComPratoSimplesFunciona() {
        Prato p = criarPrato("Frango", 54.90);
        Cardapio cardapio = new Cardapio();
        cardapio.setEmenta(p);

        assertTrue(cardapio.getEmenta().contains("Frango"));
    }

    @Test
    void cardapioComCategoriaExibeTodosOsItens() {
        Categoria categoria = criarCategoria("Pratos Principais");
        categoria.addItem(criarPrato("Picanha", 89.90));
        categoria.addItem(criarPrato("Frango", 54.90));

        Cardapio cardapio = new Cardapio();
        cardapio.setEmenta(categoria);

        String ementa = cardapio.getEmenta();
        assertTrue(ementa.contains("Pratos Principais"));
        assertTrue(ementa.contains("Picanha"));
        assertTrue(ementa.contains("Frango"));
    }

    @Test
    void cardapioComEstruturaAninhadaExibeTudo() {
        Categoria entradas = criarCategoria("Entradas");
        entradas.addItem(criarPrato("Bruschetta", 18.90));

        Categoria sobremesas = criarCategoria("Sobremesas");
        sobremesas.addItem(criarPrato("Pudim", 16.0));

        Categoria raiz = criarCategoria("Cardápio Completo");
        raiz.addItem(entradas);
        raiz.addItem(sobremesas);

        Cardapio cardapio = new Cardapio();
        cardapio.setEmenta(raiz);

        String ementa = cardapio.getEmenta();
        assertTrue(ementa.contains("Cardápio Completo"));
        assertTrue(ementa.contains("Entradas"));
        assertTrue(ementa.contains("Bruschetta"));
        assertTrue(ementa.contains("Sobremesas"));
        assertTrue(ementa.contains("Pudim"));
    }
}