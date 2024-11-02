package br.com.control.controller;

import br.com.control.model.Pessoa;
import br.com.control.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/cadastro-pessoa")
    public ModelAndView cadastroPessoa() {

        ModelAndView mv = new ModelAndView("users/cadastro-pessoa");
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
        mv.addObject("pessoaObj", new Pessoa());
        mv.addObject("pessoas", pessoasIt);

        return mv;
    }

    @PostMapping("/salvarpessoa")
    public ModelAndView salvarPessoa( @ModelAttribute Pessoa pessoa) {
        ModelAndView mv = new ModelAndView("users/cadastro-pessoa");
        try {
            pessoaRepository.save(pessoa);
            mv.addObject("msg", "Pessoa salva com sucesso!");
        } catch (Exception e) {
            mv.addObject("msg", "Erro ao salvar pessoa!"+ e.getMessage());
        }

        mv.addObject("pessoaObj", new Pessoa());
        return mv;
    }

    @GetMapping("/listaPessoa")
    public ModelAndView listaPessoas() {

        ModelAndView mv = new ModelAndView("users/cadastro-pessoa");
        Iterable<Pessoa> pessoas = pessoaRepository.findAll();
        mv.addObject("pessoas", pessoas);
        mv.addObject("pessoaObj", new Pessoa());

        return mv;

    }

    @GetMapping("/editarPessoa/{idPessoa}")
    public ModelAndView editarPessoa(@PathVariable("idPessoa") Long idPessoa) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);

        ModelAndView mv = new ModelAndView("users/cadastro-pessoa");
        mv.addObject("pessoaObj", pessoa.get());
        return mv;

    }

    @GetMapping("/removerPessoa/{idPessoa}")
    public ModelAndView removerPessoa(@PathVariable("idPessoa") Long idPessoa) {

        pessoaRepository.deleteById(idPessoa);

        ModelAndView mv = new ModelAndView("users/cadastro-pessoa");
        mv.addObject("pessoas", pessoaRepository.findAll());
        mv.addObject("pessoaObj", new Pessoa());
        return mv;

    }


}
