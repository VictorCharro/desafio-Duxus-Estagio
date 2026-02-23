package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/adicionar-time")
    public Time adicionarTime(@RequestBody Time time) {
        return apiService.adicionarTime(time.getData(), time.getComposicaoTime());
    }

    @DeleteMapping("/deletar-time")
    public void deletarTime(@RequestBody Time time) {
        apiService.deletarTime(time);
    }

    @GetMapping("/listar-times")
    public List<Time> listarTimes(){
        return apiService.listarTimes();
    }

    @PostMapping("/adicionar-integrante")
    public Integrante adicionarIntegrante(@RequestBody Integrante integrante){
        return apiService.adicionarIntegrante(integrante.getFranquia(), integrante.getNome(), integrante.getFuncao());
    }

    @DeleteMapping("/deletar-integrante")
    public void deletarIntegrante(@RequestBody Integrante integrante){
        apiService.deletarIntegrante(integrante);
    }

    @GetMapping("/listar-integrantes")
    public List<Integrante> listarIntegrantes(){
        return apiService.listarIntegrantes();
    }
}