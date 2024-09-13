package programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OrdemdeServico {
    private static final String NUMERO_OS_FILE = "numeroOS.txt";
    private static int contadorOS;
    
    static {
        // Carrega o número da OS a partir do arquivo ao iniciar
        try (BufferedReader reader = new BufferedReader(new FileReader(NUMERO_OS_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                contadorOS = Integer.parseInt(line);
            } else {
                contadorOS = 0;
            }
        } catch (IOException e) {
            // Se o arquivo não existir ou não puder ser lido, inicia o contador a partir de 0
            contadorOS = 0;
        }
    }
    
    // Atributos
    private String nomeCliente;
    private Integer telefone;
    private String tipoComputador;
    private String descricaoProblema;
    private Integer numeroOS;

    // Construtor vazio
    public OrdemdeServico() {
    }

    // Constructor com atributos
    public OrdemdeServico(String nomeCliente, Integer telefone, String tipoComputador, String descricaoProblema) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.tipoComputador = tipoComputador;
        this.descricaoProblema = descricaoProblema;
        this.numeroOS = gerarNumeroOS();
        salvarNumeroOS(); // Salva o número da OS após incrementá-lo
    }

    // Método estático para gerar o número da OS
    private static int gerarNumeroOS() {
        return ++contadorOS;
    }
    
    // Método para salvar o número da OS no arquivo
    private static void salvarNumeroOS() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NUMERO_OS_FILE))) {
            writer.write(String.valueOf(contadorOS));
        } catch (IOException e) {
            System.err.println("Erro ao salvar o número da OS: " + e.getMessage());
        }
    }

    // Getters e Setters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getTipoComputador() {
        return tipoComputador;
    }

    public void setTipoComputador(String tipoComputador) {
        this.tipoComputador = tipoComputador;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public Integer getNumeroOS() {
        return numeroOS;
    }

    public void setNumeroOS(Integer numeroOS) {
        this.numeroOS = numeroOS;
    }

    @Override
    public String toString() {
        return "Ordem de Serviço" + 
        	   "\nNome do Cliente=" + nomeCliente +
               "\nTelefone=" + telefone + 
               "\nTipo de Computador=" + tipoComputador +
               "\nDescrição do Problema=" + descricaoProblema +
               "\nNúmero da OS=" + numeroOS;
    }
}
