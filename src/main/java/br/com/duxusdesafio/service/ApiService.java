package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * OBS ao candidato: PREFERENCIALMENTE, NÃO ALTERE AS ASSINATURAS DOS MÉTODOS!
 * Trabalhe com a proposta pura.
 *
 * @author carlosau
 */
@Service
public class ApiService {

    /**
     * Vai retornar um Time, com a composição do time daquela data
     */
    public Time timeDaData(LocalDate data, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        for (Time time : todosOsTimes) {
            if (time.getData().equals(data)) {
                return time;
            }
        }
        return null;
    }

    /**
     * Vai retornar o integrante que estiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        List<Integrante> integrantes = new ArrayList<>();

        for (Time time : todosOsTimes) {

            if ((time.getData().isAfter(dataInicial) || time.getData().isEqual(dataInicial)) &&
                    (time.getData().isBefore(dataFinal) || time.getData().isEqual(dataFinal))) {

                for (int i = 0; i < time.getComposicaoTime().size(); i++) {
                    integrantes.add(time.getComposicaoTime().get(i).getIntegrante());
                }
            }
        }

        Integrante maisUsado = null;
        int contagemMaisUsado = 0;

        for (Integrante integrante : integrantes) {
            int contagemTemporaria = 0;

            for (Integrante atual : integrantes) {
                if (integrante.equals(atual)) {
                    contagemTemporaria++;
                }
            }

            if (contagemTemporaria > contagemMaisUsado) {
                maisUsado = integrante;
                contagemMaisUsado = contagemTemporaria;
            }
        }
        return maisUsado;
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> integrantesDoTimeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        List<Time> times = new ArrayList<>();

        for (Time time : todosOsTimes) {

            if ((time.getData().isAfter(dataInicial) || time.getData().isEqual(dataInicial)) &&
                    (time.getData().isBefore(dataFinal) || time.getData().isEqual(dataFinal))) {

                for (int i = 0; i < todosOsTimes.size(); i++) {
                    times.add(time);
                }
            }
        }

        Time maisComum = null;
        int contagemMaisComum = 0;

        for (Time time : times) {
            int contagemTemporaria = 0;

            for (Time atual : times) {
                if (time.equals(atual)) {
                    contagemTemporaria++;
                }
            }

            if (contagemTemporaria > contagemMaisComum) {
                maisComum = time;
                contagemMaisComum = contagemTemporaria;
            }
        }
        List<String> ListaMaisComums = new ArrayList<>();
        for (int i = 0; i < maisComum.getComposicaoTime().size(); i++) {
            ListaMaisComums.add(maisComum.getComposicaoTime().get(i).getIntegrante().getNome());
        }
        return ListaMaisComums;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        List<String> funcoes = new ArrayList<>();

        for (Time time : todosOsTimes) {

            if ((time.getData().isAfter(dataInicial) || time.getData().isEqual(dataInicial)) &&
                    (time.getData().isBefore(dataFinal) || time.getData().isEqual(dataFinal))) {

                for (int i = 0; i < time.getComposicaoTime().size(); i++) {
                    funcoes.add(time.getComposicaoTime().get(i).getIntegrante().getFuncao());
                }
            }
        }

        int contagemMaisComum = 0;
        String funcaoMaisComum = "";

        for (String funcao : funcoes) {
            int contagemTemporaria = 0;

            for (String atual : funcoes) {
                if (funcao.equals(atual)) {
                    contagemTemporaria++;
                }
            }

            if (contagemTemporaria > contagemMaisComum) {
                funcaoMaisComum = funcao;
                contagemMaisComum = contagemTemporaria;
            }
        }
        return funcaoMaisComum;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        List<String> franquias = new ArrayList<>();

        for (Time time : todosOsTimes) {

            if ((time.getData().isAfter(dataInicial) || time.getData().isEqual(dataInicial)) &&
                    (time.getData().isBefore(dataFinal) || time.getData().isEqual(dataFinal))) {

                for (int i = 0; i < time.getComposicaoTime().size(); i++) {
                    franquias.add(time.getComposicaoTime().get(i).getIntegrante().getFranquia());
                }
            }
        }

        int contagemFranquiaMaisFamosa = 0;
        String FranquiaMaisFamosa = "";

        for (String franquia : franquias) {
            int contagemTemporaria = 0;

            for (String atual : franquias) {
                if (franquia.equals(atual)) {
                    contagemTemporaria++;
                }
            }

            if (contagemTemporaria > contagemFranquiaMaisFamosa) {
                FranquiaMaisFamosa = franquia;
                contagemFranquiaMaisFamosa = contagemTemporaria;
            }
        }
        return FranquiaMaisFamosa;
    }


    /**
     * Vai retornar o número (quantidade) de Franquias dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        Map <String, Long> contagemFranquia = new HashMap<>();

        for (Time time : todosOsTimes) {

            if ((time.getData().isAfter(dataInicial) || time.getData().isEqual(dataInicial)) &&
                    (time.getData().isBefore(dataFinal) || time.getData().isEqual(dataFinal))) {

                String nomeFranquia = time.getComposicaoTime().get(0).getIntegrante().getFranquia();

                if(!contagemFranquia.toString().contains(nomeFranquia)) {
                    contagemFranquia.put(nomeFranquia, 1L);
                }
            }
        }
        return contagemFranquia;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        Map <String, Long> contagemFuncao = new HashMap<>();

        for (Time time : todosOsTimes) {

            if ((time.getData().isAfter(dataInicial) || time.getData().isEqual(dataInicial)) &&
                    (time.getData().isBefore(dataFinal) || time.getData().isEqual(dataFinal))) {

                String nomeFuncao = time.getComposicaoTime().get(0).getIntegrante().getFuncao();

                if(contagemFuncao.toString().contains(nomeFuncao)) {
                    contagemFuncao.merge(nomeFuncao, 1L, Long::sum);
                }
                else {
                    contagemFuncao.put(nomeFuncao, 1L);
                }
            }
        }
        return contagemFuncao;
    }

}
