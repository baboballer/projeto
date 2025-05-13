package org.iftm.projeto9033.entities;

public class Aluno {
    //nome, cpf, telefone, email, matricula, endereco
    public class Aluno {
        private String nome;
        private String cpf;
        private String telefone;
        private String email;
        private String matricula;
        private String endereco;
    
        // Construtor
        public Aluno(String nome, String cpf, String telefone, String email, String matricula, String endereco) {
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.email = email;
            this.matricula = matricula;
            this.endereco = endereco;
        }
    
        // Getters e Setters
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getCpf() {
            return cpf;
        }
    
        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
    
        public String getTelefone() {
            return telefone;
        }
    
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getMatricula() {
            return matricula;
        }
    
        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }
    
        public String getEndereco() {
            return endereco;
        }
    
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
    
        // Método para exibir os dados do aluno
        public void exibirDados() {
            System.out.println("Nome: " + nome);
            System.out.println("CPF: " + cpf);
            System.out.println("Telefone: " + telefone);
            System.out.println("Email: " + email);
            System.out.println("Matrícula: " + matricula);
            System.out.println("Endereço: " + endereco);
        }
    }
}
