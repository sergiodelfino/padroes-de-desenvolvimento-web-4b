package recursos;

import java.util.List;

import entidades.Produto;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("produtos")
public class ProdutoRecurso {
    @GET
    public List<Produto> listar () {
        return Produto.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar (Produto produto) {
        produto.persist();
    }
}
