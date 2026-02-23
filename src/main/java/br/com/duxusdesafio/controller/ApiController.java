package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @DeleteMapping("/deletar-time/{id}")
    public void deletarTime(@PathVariable Long id) {
        apiService.deletarTime(id);
    }

    @GetMapping("/listar-times")
    public List<Time> listarTimes(){
        return apiService.listarTimes();
    }

    @GetMapping("/listar-times/{id}")
    public Time listarTimes(@PathVariable Long id){
        return apiService.listarTimePeloId(id);
    }

    @PostMapping("/adicionar-integrante")
    public Integrante adicionarIntegrante(@RequestBody Integrante integrante){
        return apiService.adicionarIntegrante(integrante);
    }

    @GetMapping("/listar-integrantes")
    public List<Integrante> listarIntegrantes(){
        return apiService.listarIntegrantes();
    }

    @GetMapping("/listar-integrantes/{id}")
    public Integrante listarIntegrantes(@PathVariable Long id){
        return apiService.listarIntegrantePeloId(id);
    }
}