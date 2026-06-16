package br.edu.ifsc.fln.domain;

public class HistoricaoMedicacao {

    private String descricao;

    private RegistroConsulta registroConsulta;
    private Medicamento medicamento;


    public HistoricaoMedicacao() {
    }

    public HistoricaoMedicacao(RegistroConsulta registroConsulta, Medicamento medicamento, String descricao) {
        this.descricao = descricao;
        this.registroConsulta = registroConsulta;
        this.medicamento = medicamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public RegistroConsulta getRegistroConsulta() {
        return registroConsulta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

}
