import br.edu.ifsc.fln.domain.*;
import br.edu.ifsc.fln.exceptions.MedicamentoIndicadoException;
import br.edu.ifsc.fln.report.RelatorioConsulta;

public class MainApp {
    public static void main(String[] args) {
        Cidade cidade1 = new Cidade("Florianópolis", "SC");
        Cidade cidade2 = new Cidade("Ijuí", "RS");
        Cidade cidade3 = new Cidade();
        cidade3.setNome("Lages");
        cidade3.setUf("SC");

        Medicamento  medicamento1 = new Medicamento("Paracetamol", "EMS");
        Medicamento  medicamento2 = new Medicamento("Amoxicilina", "Medley");


        Pessoa paciente1 = new Paciente("João", "12332145678", "Rua das Flores", cidade1);
        paciente1.setCpf("321312145678");
        ((Paciente)paciente1).atualizarEndereco("Rua X de Novembro", cidade3);

        Paciente paciente2 = new Paciente("Maria", "43223456789", "Rua das Neves", cidade2);

        Pessoa medico1 = new Medico("Dra. Ana", "45678932100", "Cardiologia", "CRM1234");


        Consulta consulta1 = new Consulta("06/12/2024", "10:00", (Medico)medico1, (Paciente)paciente1, Prioridade.BAIXA,
                StatusConsulta.AGENDADA, "br.edu.ifsc.fln.domain.Paciente relatou fortes dores de cabeça");
        try {
            consulta1.getRegistroConsulta().prescreverMedicamento(medicamento1, "tomar de 8 em 8 horas após as refeições");
        } catch (MedicamentoIndicadoException e) {
            System.out.println("Erro: " + e.getMessage());;
        }

        RelatorioConsulta.imprimirDetalhes(consulta1);

        Consulta consulta2 = new Consulta("01/07/2025", "16:00", (Medico)medico1, paciente2,
                Prioridade.MEDIA, StatusConsulta.REALIZADA, "Está apresentando uma infecção");
        try {
            consulta2.getRegistroConsulta().prescreverMedicamento(medicamento1, "tomar de 8 em 8 horas ");
            consulta2.getRegistroConsulta().prescreverMedicamento(medicamento2, "tomar antes de dormir");
            consulta2.getRegistroConsulta().prescreverMedicamento(medicamento2, "tomar antes de dormir");

        } catch (MedicamentoIndicadoException e) {
            System.out.println("Erro: " + e.getMessage());;
        }


        RelatorioConsulta.imprimirDetalhes(consulta2);

        //printConsultas(medico1);
        //printConsultas(paciente1);

    }

    public static void printConsultas(Pessoa pessoa) {

        if (pessoa instanceof Paciente) {
            System.out.println("Consultas do br.edu.ifsc.fln.domain.Paciente");
            System.out.println("Nome: " + pessoa.getNome());
            for (Consulta consulta : ((Paciente) pessoa).getConsultas()) {
                System.out.println("br.edu.ifsc.fln.domain.Consulta " + consulta.toString());
            }
        } else {
            System.out.println("Consultas do Médico");
            System.out.println("Nome: " + pessoa.getNome());
            for (Consulta consulta : ((Medico) pessoa).getConsultas()) {
                System.out.println("br.edu.ifsc.fln.domain.Consulta " + consulta.toString());
            }
        }
    }

    public static void printInformacoes(Pessoa pessoa) {
        pessoa.exibirInformacoes();
        if (pessoa instanceof Medico) {
            System.out.println("CRM: " + ((Medico)pessoa).getCpf());
        }
    }

    public static void printConsultas(Medico medico) {
        System.out.println("****** CONSULTAS DO MEDICO ******");
        System.out.println("Nome: " + medico.getNome());
        if (medico.getConsultas().isEmpty()) {
            System.out.println("Nenhuma consulta realizada pelo médico.");
        } else {
            for (Consulta consulta : medico.getConsultas()) {
                System.out.println("br.edu.ifsc.fln.domain.Paciente.................: " + consulta.getPaciente().getNome());
                System.out.println("br.edu.ifsc.fln.domain.Cidade do paciente.......: " +
                        consulta.getPaciente().getEndereco().getCidade().getNome());
                System.out.println("Data.....................: " + consulta.getDataConsulta());
                System.out.println("Horário..................: " + consulta.getHorario());
                System.out.println("br.edu.ifsc.fln.domain.Prioridade...............: " + consulta.getPrioridade());
                System.out.println("Status da br.edu.ifsc.fln.domain.Consulta.......: " + consulta.getStatusConsulta());
                System.out.println();
            }
        }

    }


}
