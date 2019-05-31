package com.hotel.controllers;

import com.hotel.model.Pessoa;
import com.hotel.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaBean {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/formpessoa")
    public  String inicio(){
        return "cadastro/formpessoa";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa")
    public  String salvar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
        return "cadastro/formpessoa";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listapessoas")
    public ModelAndView pessoas(){
        ModelAndView andView = new ModelAndView("cadastro/formpessoa");
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
        andView.addObject("pessoas" , pessoasIt);
        return  andView;
    }
}
