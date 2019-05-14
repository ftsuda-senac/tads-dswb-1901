/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/exemplo-sessao3")
@Scope("session")
public class ExemploSessao3Controller {
    
    private List<Long> idsSelecionados = new ArrayList<>();

    @GetMapping
    public ModelAndView listarProdutos() {
        List<Produto> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto(1L, "Produto 1"));
        produtosDisponiveis.add(new Produto(2L, "Produto 2"));
        produtosDisponiveis.add(new Produto(3L, "Produto 3"));
        produtosDisponiveis.add(new Produto(4L, "Produto 4"));
        return new ModelAndView("produtos").addObject("produtos", produtosDisponiveis);
    }
    
    @PostMapping("/adicionar")
    public ModelAndView adicionar(@RequestParam("id") long idSelecionado) {
        idsSelecionados.add(idSelecionado);
        return new ModelAndView("redirect:/exemplo-sessao3");
    }

    @ModelAttribute("idsSelecionados")
    public List<Long> getIdsSelecionados() {
        return idsSelecionados;
    }
}
