package br.com.casadocodigo.loja.dto;


import br.com.casadocodigo.loja.models.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDTO {


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataGeracao;
    private int quantidade;
    private List<Produto> produtos;

    public RelatorioDTO(LocalDateTime dataGeracao, int quantidade, List<Produto> produtos) {
        this.dataGeracao = dataGeracao;
        this.quantidade = quantidade;
        this.produtos = produtos;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
