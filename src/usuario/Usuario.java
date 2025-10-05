package usuario;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senhaHash;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public boolean autenticar(String senhaRaw) {
        // Protótipo: comparamos texto (em produção, usar hashing + salt)
        boolean ok = (senhaRaw != null && senhaRaw.equals(this.senhaHash));
        System.out.println("Autenticar " + email + " resultado: " + ok);
        return ok;
    }

    public void atualizarPerfil(String novoNome, String novoEmail) {
        setNome(novoNome);
        setEmail(novoEmail);
        System.out.println("Perfil atualizado: " + nome + " / " + email);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome='" + nome + '\'' + ", email='" + email + '\'' + '}';
    }
}
