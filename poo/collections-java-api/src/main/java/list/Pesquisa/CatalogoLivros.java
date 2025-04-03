package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    List<Livro> catalogoLivros;

    public CatalogoLivros() {
        catalogoLivros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicado) {
        catalogoLivros.add(new Livro(titulo, autor, anoPublicado));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        if (catalogoLivros.isEmpty()) {
            System.out.println("Catálogo vazio!");
            return new ArrayList<>();
        }

        List<Livro> livrosPorAutor = new ArrayList<>();

        for (Livro livro : catalogoLivros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(livro);
            }
        }

        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        if (catalogoLivros.isEmpty()) {
            System.out.println("Catálogo vazio!");
            return new ArrayList<>();
        }

        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();

        for (Livro livro : catalogoLivros) {
            if (livro.getAnoPublicado() >= anoInicial && livro.getAnoPublicado() <= anoFinal) {
                livrosPorIntervaloAnos.add(livro);
            }
        }

        return livrosPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        if (catalogoLivros.isEmpty()) {
            System.out.println("Catálogo vazio!");
            return null;
        }

        Livro livroPorTitulo = null;
        for (Livro livro : catalogoLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroPorTitulo = livro;
                break;
            }
        }

        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2010);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2015);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 3", 2011);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 4", 2004);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 5", 2005);
        catalogoLivros.adicionarLivro("Livro 5", "Autor 2", 1999);

        System.out.println(catalogoLivros.pesquisarPorAutor("autor 2"));

        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2005, 2010));

        System.out.println(catalogoLivros.pesquisarPorTitulo("livro 2"));
    }
}
