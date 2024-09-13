package programa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUIOrdemdeServico {
    public static void main(String[] args) {
        // Criação do JFrame
        JFrame frame = new JFrame("Ordem de Serviço");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Painel para os campos de entrada
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Labels e Campos de Texto
        JLabel labelNome = new JLabel("Nome do Cliente:");
        JTextField fieldNome = new JTextField();

        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField fieldTelefone = new JTextField();

        JLabel labelTipo = new JLabel("Tipo de Computador:");
        JTextField fieldTipo = new JTextField();

        JLabel labelDescricao = new JLabel("Descrição do Problema:");
        JTextArea areaDescricao = new JTextArea(4, 20);
        JScrollPane scrollPane = new JScrollPane(areaDescricao);

        // Adiciona os componentes ao painel
        panelForm.add(labelNome);
        panelForm.add(fieldNome);
        panelForm.add(labelTelefone);
        panelForm.add(fieldTelefone);
        panelForm.add(labelTipo);
        panelForm.add(fieldTipo);
        panelForm.add(labelDescricao);
        panelForm.add(scrollPane);

        frame.add(panelForm, BorderLayout.CENTER);

        // Botão Salvar
        JButton btnSave = new JButton("Salvar");
        ImageIcon saveIcon = new ImageIcon("path/to/save_icon.png"); // Adicione o caminho correto
        btnSave.setIcon(saveIcon);

        // Painel para o botão
        JPanel panelButton = new JPanel();
        panelButton.add(btnSave);
        frame.add(panelButton, BorderLayout.SOUTH);

        // Evento de clique do botão
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = fieldNome.getText().trim();
                String telefoneText = fieldTelefone.getText().trim();
                String tipo = fieldTipo.getText().trim();
                String descricao = areaDescricao.getText().trim();

                if (nome.isEmpty() || telefoneText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int telefone;
                try {
                    telefone = Integer.parseInt(telefoneText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Telefone deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                OrdemdeServico os = new OrdemdeServico(nome, telefone, tipo, descricao);
                Integer numeroOS = os.getNumeroOS();

                String timestamp = new SimpleDateFormat("dd_MM_yyyy_").format(new Date());
                String filename = "OrdemDeServico_" + timestamp + numeroOS + ".txt";

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                    writer.write(os.toString());
                    JOptionPane.showMessageDialog(frame, "Objeto salvo com sucesso em " + filename + "!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao salvar o objeto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Torna o JFrame visível
        frame.setVisible(true);
    }
}
