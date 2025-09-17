package entidades;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class ProdutoTests {
    @Test
    @Transactional
    public void testBuscaUmaCategoriaBuscaUmFabricanteSalvaUmProduto() {
        Produto produto = new Produto ();
        produto.nome = "Fanta Laranja 2 Litros";
        produto.preco = 9.45;
        produto.quantidade = 50;
        produto.validade = LocalDate.of(2025, 12, 20);

        produto.categoria = Categoria.findById(1);
        produto.fabricante = Fabricante.findById(2);

        produto.persist();

        Assertions.assertEquals(2, produto.codigo);
    }
}
