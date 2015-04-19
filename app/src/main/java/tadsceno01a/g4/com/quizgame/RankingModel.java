package tadsceno01a.g4.com.quizgame;

public class RankingModel
{
    private String nome;
    private String nota;

    public RankingModel(String nomeAluno, String notaAluno)
    {
        this.nome = nomeAluno;
        this.nota = notaAluno;
    }

    public String getNome()
    {
        return nome;
    }

    public void  setNome(String value)
    {
        nome = value;
    }

    public String getNota()
    {
        return nota;
    }

    public void setNota(String value)
    {
        nota = value;
    }

}
