package br.com.control.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.control.model.Pessoa;
import br.com.control.repository.PessoaRepository;

@Controller
public class PageController {

    private PessoaRepository pessoaRepository;

    @Autowired
    public void setPessoaRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/index")
    public ModelAndView usuario() {

        ModelAndView mv = new ModelAndView("views/index");
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
        mv.addObject("pessoaObj", new Pessoa());
        mv.addObject("pessoas", pessoasIt);

        return mv;
    }


    @GetMapping("/estoque")
    public String estoque() {
        return "users/estoque";
    }

    @GetMapping("/entrada")
    public String entrada() {
        return "users/entradamaterial";
    }

}
