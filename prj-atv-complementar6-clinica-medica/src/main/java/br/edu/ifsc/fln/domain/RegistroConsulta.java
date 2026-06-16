package br.edu.ifsc.fln.domain;

import br.edu.ifsc.fln.exceptions.MedicamentoIndicadoException;

import java.util.ArrayList;
import java.util.List;

public class RegistroConsulta {
    private String descricao;

    private List<HistoricaoMedicacao> historicoMedicacao;

    public RegistroConsulta(String descricao) {
        this.descricao = descricao;
        this.historicoMedicacao = new ArrayList<HistoricaoMedicacao>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<HistoricaoMedicacao> getHistoricoMedicacao() {
        return historicoMedicacao;
    }

    public void prescreverMedicamento(Medicamento medicamento, String descricao) throws MedicamentoIndicadoException {
        HistoricaoMedicacao  historicaoMedicacao = new HistoricaoMedicacao(this, medicamento, descricao);
        for (HistoricaoMedicacao h : historicoMedicacao) {
            if (h.getMedicamento().equals(medicamento)) {
                throw new MedicamentoIndicadoException("Medicação duplicada");
            }
        }
        this.historicoMedicacao.add(historicaoMedicacao);
    }

}
