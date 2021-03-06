/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplospringsecurity.entidade;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author fernando.tsuda
 */
public class Papel implements GrantedAuthority {

    private String nome;

    public Papel() {
    }

    public Papel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
     * Fornece o nome do papel que será validado pelo Spring Security
     */
    @Override
    public String getAuthority() {
        return getNome();
    }

}
