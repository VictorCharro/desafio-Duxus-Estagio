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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/time-da-data")
    public Time timeDaData(@RequestParam LocalDate data) {
        return apiService.timeDaData(data, apiService.listarTimes());
    }

    @GetMapping("/integrante-mais-usado")
    public Integrante integranteMaisUsado(@RequestParam(required = false) LocalDate dataInicial,
                                          @RequestParam(required = false) LocalDate dataFinal) {
        return apiService.integranteMaisUsado(dataInicial, dataFinal, apiService.listarTimes());
    }

    @GetMapping("/integrantes-time-mais-comum")
    public List<String> integrantesDoTimeMaisComum(@RequestParam(required = false) LocalDate dataInicial,
                                                   @RequestParam(required = false) LocalDate dataFinal) {
        return apiService.integrantesDoTimeMaisComum(dataInicial, dataFinal, apiService.listarTimes());
    }

    @GetMapping("/funcao-mais-comum")
    public String funcaoMaisComum(@RequestParam(required = false) LocalDate dataInicial,
                                  @RequestParam(required = false) LocalDate dataFinal) {
        return apiService.funcaoMaisComum(dataInicial, dataFinal, apiService.listarTimes());
    }

    @GetMapping("/franquia-mais-famosa")
    public String franquiaMaisFamosa(@RequestParam(required = false) LocalDate dataInicial,
                                     @RequestParam(required = false) LocalDate dataFinal) {
        return apiService.franquiaMaisFamosa(dataInicial, dataFinal, apiService.listarTimes());
    }

    @GetMapping("/contagem-por-franquia")
    public Map<String, Long> contagemPorFranquia(@RequestParam(required = false) LocalDate dataInicial,
                                                 @RequestParam(required = false) LocalDate dataFinal) {
        return apiService.contagemPorFranquia(dataInicial, dataFinal, apiService.listarTimes());
    }

    @GetMapping("/contagem-por-funcao")
    public Map<String, Long> contagemPorFuncao(@RequestParam(required = false) LocalDate dataInicial,
                                               @RequestParam(required = false) LocalDate dataFinal) {
        return apiService.contagemPorFuncao(dataInicial, dataFinal, apiService.listarTimes());
    }
}