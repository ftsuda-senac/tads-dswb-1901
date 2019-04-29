/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspringjpa.controller;

import br.senac.tads.dsw.exemplosspringjpa.entidade.Categoria;
import br.senac.tads.dsw.exemplosspringjpa.entidade.Produto;
import br.senac.tads.dsw.exemplosspringjpa.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ModelAndView listar() {
        return new ModelAndView("produto/lista");
    }

    @GetMapping("/novo")
    public ModelAndView adicionarNovo() {
        return new ModelAndView("produto/formulario").addObject("produto", new Produto());
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(Long id) {
        return new ModelAndView("produto/formulario").addObject("produto", new Produto());
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        return new ModelAndView("redirect:/produto");
    }

    @PostMapping("/{id}/remover")
    public ModelAndView remover(Long id) {
        return new ModelAndView("redirect:/produto");
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

}
