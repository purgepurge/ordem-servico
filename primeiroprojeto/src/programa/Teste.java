package programa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// Criando uma instância da classe OrdemdeServico
			OrdemdeServico os = new OrdemdeServico();
			
			// pedindo ao usuario para inserir valores do objeto
			
     
			System.out.println("digite o nome do cliente: ");
			os.setNomeCliente(scanner.nextLine());
			
			System.out.println("digite o telefone do cliente: ");
			os.setTelefone(scanner.nextInt());
			scanner.nextLine(); //limpa o scanner.
			
			System.out.println("digite o tipo de aparelho do cliente: ");
			os.setTipoComputador(scanner.nextLine());
			
			System.out.println("digite qual o problema: ");
			os.setDescricaoProblema(scanner.nextLine());
      

			// checando os valores
			
			System.out.println("Nome do Cliente: " + os.getNomeCliente());
			System.out.println("Telefone: " + os.getTelefone());
			System.out.println("Tipo de Computador: " + os.getTipoComputador());
			System.out.println("Descrição do Problema: " + os.getDescricaoProblema());
			System.out.println("Número da OS: " + os.getNumeroOS());
			
			// nome do arquivo onde o Objeto vai ser salvo
			String OS = os.getNumeroOS() + ".txt";

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(OS))) {
			    // Escreve a representação do objeto no arquivo
			    writer.write(os.toString());			
			    System.out.println("Objeto salvo com sucesso em " + OS);
			} catch (IOException e) {
			    System.err.println("Erro ao salvar o objeto: " + e.getMessage());
			}
		}
    }
}
