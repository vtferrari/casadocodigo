package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public Callable<ModelAndView> detalhe() {
        return () -> {
            URI uri = new URI("https://book-payment.herokuapp.com/orders");
            final List<PedidoDTO> pedidos = restTemplate.exchange(uri, HttpMethod.GET, null,  new ParameterizedTypeReference<List<PedidoDTO>>() {
            }).getBody();

            ModelAndView modelAndView = new ModelAndView("pedidos");
            modelAndView.addObject("pedidos", pedidos);
            return modelAndView;
        };
    }
}
