package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import javafx.scene.input.DataFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        manager.persist(produto);
    }

    public List<Produto> listar() {
        return manager.createQuery("select distinct(p) from Produto p join fetch p.precos", Produto.class)
                .getResultList();
    }

    public List<Produto> listarPor(LocalDate data) {
        return manager.createQuery("select distinct(p) from Produto p join fetch p.precos WHERE p.dataLancamento > :data", Produto.class)
                .setParameter("data", GregorianCalendar.from(data.atStartOfDay(ZoneId.systemDefault())))
                .getResultList();
    }

    public Produto find(Integer id) {
        return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id",
                Produto.class).setParameter("id", id)
                .getSingleResult();
    }

    public BigDecimal somaPrecosPorTipo(TipoPreco tipoPreco) {
        TypedQuery<BigDecimal> query = manager.createQuery("select sum(preco.valor) from Produto p join p.precos preco "
                + "where preco.tipo = :tipoPreco", BigDecimal.class);
        query.setParameter("tipoPreco", tipoPreco);
        return query.getSingleResult();
    }
}