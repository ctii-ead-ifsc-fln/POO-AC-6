package br.edu.ifsc.fln.domain;

public class Consulta {
    private String dataConsulta;
    private String horario;

    private Medico medico;
    private Paciente paciente;

    private Prioridade prioridade = Prioridade.BAIXA;
    private StatusConsulta statusConsulta;

    private RegistroConsulta registroConsulta;

    public Consulta() {
    }

    public Consulta(String dataConsulta, String horario, Medico medico, Paciente paciente, Prioridade prioridade, StatusConsulta statusConsulta, String descricaoConsulta) {
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.prioridade = prioridade;
        this.statusConsulta = statusConsulta;
        this.medico.agendarConsulta(this);
        this.paciente.agendarConsulta(this);
        this.registroConsulta = new RegistroConsulta(descricaoConsulta);
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public RegistroConsulta getRegistroConsulta() {
        return registroConsulta;
    }

    @Override
    public String toString() {
        return "br.edu.ifsc.fln.domain.Consulta{" +
                "dataConsulta='" + dataConsulta + '\'' +
                ", horario='" + horario + '\'' +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", prioridade=" + prioridade +
                ", statusConsulta=" + statusConsulta +
                '}';
    }
}
