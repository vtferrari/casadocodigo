package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.dto.RelatorioDTO;
import br.com.casadocodigo.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("relatorio-produtos")
public class RelatorioProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping
    public ResponseEntity<RelatorioDTO> getRelatorio(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        final List<Produto> produtos = produtoDAO.listarPor(data);
        if (produtos.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RelatorioDTO(LocalDateTime.now(), 0, new ArrayList<>()));
        }
        return ResponseEntity.ok(new RelatorioDTO(LocalDateTime.now(), produtos.size(), produtos));
    }

}
