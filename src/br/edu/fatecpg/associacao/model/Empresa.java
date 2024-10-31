package br.edu.fatecpg.associacao.model;

public class Empresa {
    private String nomeEmpresa;
    private Cliente[] clientes;
    private Funcionario[] funcionarios;

    public Empresa(String nome) {
        this.nomeEmpresa = nome;
        this.clientes = new Cliente[5];
        this.funcionarios = new Funcionario[10];
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void adicionarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                return;
            }
        }
        System.out.println("Limite de clientes atingido! Não é possível adicionar mais clientes.");
    }

    public void exibirClientes() {
        if (vazioClientes()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        StringBuilder clienteInfo = new StringBuilder("Clientes cadastrados:\n");
        for(int c = 0; c < 5; c++) {
			if(this.clientes[c] == null) {
				continue;    
			}
            clienteInfo.append("Nome: ").append(clientes[c].getNome()).append(", Email: ").append(clientes[c].getEmail()).append("\n");
        }
        System.out.println(clienteInfo.toString());
    }
    
	public boolean vazioClientes() {
		int total = 0;
		for(int c = 0; c<5 ; c++) {
			if(this.clientes[c] == null) {
				total++;
			}
		}
		if(total == 5 ){
			return true;
		}
		else {
			return false;
		}
	}
	

    public void adicionarFuncionario(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] == null) {
            	funcionarios[i] = funcionario;
                return;
            }
        }
        System.out.println("Limite de funcionarios atingido! Não é possível adicionar mais funcionarios.");

    }

    public void exibirFuncionarios() {
        if (vazioFuncionarios()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        StringBuilder FuncInfo = new StringBuilder("Funcionarios cadastrados:\n");
        for(int c = 0; c < 10; c++) {
			if(this.funcionarios[c] == null) {
				continue;    
			}
			FuncInfo.append("Nome: ").append(funcionarios[c].getNome()).append(", Email: ").append(funcionarios[c].getCargo()).append("\n");
        }
        System.out.println(FuncInfo.toString());
    }

	public boolean vazioFuncionarios() {
		int total = 0;
		for(int c = 0; c < 10 ; c++) {
			if(this.funcionarios[c] == null) {
				total++;
			}
		}
		if(total == 10){
			return true;
		}
		else {
			return false;
		}
	}
	
    public double calcularMediaSalarial() {
        Calculadora calculadora = new Calculadora();
        double totalSalarios = 0;
        int contadorFuncionarios = 0;

        for(int c = 0; c < 10; c++) {
			if(this.funcionarios[c] != null) {
                totalSalarios = calculadora.somar(totalSalarios, funcionarios[c].getSalario());
                contadorFuncionarios++;
            }
        }

        if (contadorFuncionarios == 0) {
        	return 0;
        }
        else {
            System.out.println("Total de sálarios: " + totalSalarios);
        	return calculadora.dividir(totalSalarios, contadorFuncionarios);
        }
    }

    public void exibirMediaSalarial() {
        System.out.println("Média salarial: " + calcularMediaSalarial());
    }
}
