package br.edu.ifsc.fln.domain;

public class Endereco {
    private String rua;

    //a associação de classes unidirecional entre br.edu.ifsc.fln.domain.Endereco e br.edu.ifsc.fln.domain.Cidade
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String rua, Cidade cidade) {
        this.rua = rua;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "br.edu.ifsc.fln.domain.Endereco{" +
                "rua='" + rua + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
