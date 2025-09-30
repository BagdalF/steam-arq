public abstract class Usuario {
    protected int id;
    protected String nome;
    protected String email;
    protected String senhaHash;

    public Usuario(int id, String nome, String email, String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    public boolean autenticar(String senha) {
        // stub simples: compara hash direto (não use em produção)
        boolean ok = senha != null && senha.equals(this.senhaHash);
        System.out.println("Autenticação de " + email + ": " + (ok ? "sucesso" : "falha"));
        return ok;
    }

    public void atualizarPerfil(String novoNome, String novoEmail) {
        System.out.println("Atualizando perfil de " + this.email);
        this.nome = novoNome;
        this.email = novoEmail;
        System.out.println("Perfil atualizado: " + this.nome + " / " + this.email);
    }

    // getters / setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
}
