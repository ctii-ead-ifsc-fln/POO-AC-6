package br.edu.ifsc.fln.report;

import br.edu.ifsc.fln.domain.Consulta;
import br.edu.ifsc.fln.domain.HistoricaoMedicacao;

public class RelatorioConsulta {

    public static void imprimirDetalhes(Consulta consulta) {
        System.out.println("\n******* DADOS DA CONSULTA *******");
        System.out.println("Médico...................: " + consulta.getMedico().getNome());
        System.out.println("br.edu.ifsc.fln.domain.Paciente.................: " + consulta.getPaciente().getNome());
        System.out.println("br.edu.ifsc.fln.domain.Cidade do paciente.......: " +
                consulta.getPaciente().getEndereco().getCidade().getNome());
        System.out.println("Data.....................: " + consulta.getDataConsulta());
        System.out.println("Horário..................: " + consulta.getHorario());
        System.out.println("br.edu.ifsc.fln.domain.Prioridade...............: " + consulta.getPrioridade());
        System.out.println("Status da br.edu.ifsc.fln.domain.Consulta.......: " + consulta.getStatusConsulta());
        System.out.println("=================================");
        System.out.println("*** Histórico da Medicação e da consulta ***");
        System.out.println("Descrição da consulta...: " + consulta.getRegistroConsulta().getDescricao());
        for (HistoricaoMedicacao hm : consulta.getRegistroConsulta().getHistoricoMedicacao()) {
            System.out.println("br.edu.ifsc.fln.domain.Medicamento: " +  hm.getMedicamento().getNome());
            System.out.println("Uso........: " +  hm.getDescricao());
        }
    }
}
