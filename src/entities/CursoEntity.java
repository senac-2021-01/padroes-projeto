package src.entities;

public class CursoEntity {

    private int id;
    private String nome;
    private String descricao;

    public boolean equals(Object obj) {
        return this.id == ((CursoEntity) obj).getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
