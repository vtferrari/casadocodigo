package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioDAO dao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new UsuarioValidator());
    }

    @RequestMapping("/form")
    public ModelAndView form(Usuario usuario) {
        ModelAndView modelAndView = new ModelAndView("usuarios/form");
        return modelAndView;
    }

    @PostMapping
    @Transactional
    public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return form(usuario);
        }

        final Usuario usuario1 = dao.find(usuario.getEmail());

        if (usuario1 != null) {
            redirectAttributes.addFlashAttribute("falha", "Usuario já cadastrado");
        } else{
            dao.gravar(usuario);
            redirectAttributes.addFlashAttribute("sucesso", "Usuario cadastrado com sucesso!");
        }


        return new ModelAndView("redirect:/usuarios");
    }

    @GetMapping
    public ModelAndView listar() {
        List<Usuario> usuarios = dao.listar();
        ModelAndView modelAndView = new ModelAndView("usuarios/lista");
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }
}
