package br.edu.ifsc.fln.domain;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa implements Agendavel {
    private Endereco endereco;

    private List<Consulta> consultas;

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Paciente() {
        endereco = new Endereco();
        this.consultas = new ArrayList<>();
    }

    public Paciente(String nome, String cpf, String rua, Cidade cidade ) {
        super(nome, cpf);
        this.endereco = new Endereco(rua, cidade);
        this.consultas = new ArrayList<>();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("br.edu.ifsc.fln.domain.Paciente: " + getNome() + ", CPF: " + getCpf() + ", br.edu.ifsc.fln.domain.Endereco: " + endereco);
    }

    public void atualizarEndereco(String rua, Cidade cidade) {
        this.endereco = new Endereco(rua, cidade);
    }

    public void agendarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    @Override
    public String toString() {
        return "br.edu.ifsc.fln.domain.Paciente{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
