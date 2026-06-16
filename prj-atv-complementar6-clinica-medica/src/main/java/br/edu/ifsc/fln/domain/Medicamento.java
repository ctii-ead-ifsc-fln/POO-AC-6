package br.edu.ifsc.fln.domain;

import java.util.Objects;

public class Medicamento {
    private String nome;
    private String fabricante;

    public Medicamento(String nome, String fabricante) {
        this.nome = nome;
        this.fabricante = fabricante;
    }

    public Medicamento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicamento)) return false;
        Medicamento that = (Medicamento) o;
        return nome.equalsIgnoreCase(that.nome) && fabricante.equalsIgnoreCase(that.fabricante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase(), fabricante.toLowerCase());
    }
}
