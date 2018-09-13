

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


import javax.swing.JOptionPane;

import br.com.apex.prova.contato.Contato;

public class TelaUsuario {

	
	public static void main(String[] args) {

		
    	   Scanner s = new Scanner(System.in);
           
        Contato contato = new Contato();
        JOptionPane.showMessageDialog(null, "Bem-vindo ao nosso menu de cadastro", "Cliente", 0);
   		contato.setNome(JOptionPane.showInputDialog(null, "Digite seu nome"));
   		contato.setSobrenome(JOptionPane.showInputDialog(null, "Digite seu sobrenome"));
        contato.setEmail(JOptionPane.showInputDialog(null, "Digite seu email")); 
        contato.verificar();
   		contato.setTelefone( Integer.parseInt(JOptionPane.showInputDialog(null, "Digite seu número de telefone" )));
   		contato.setSexo(JOptionPane.showInputDialog("Digite F para feminino ou M para masculino" )); 
   		contato.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua idade" )));
   		
   		JOptionPane.showMessageDialog(null, "Nome: " + contato.getNome() +"\n" + "Sobrenome: " +"\n" + contato.getSobrenome() +"\n" + "E-mail: " + contato.getEmail() +"\n" + "Telefone: " + contato.getTelefone() 
   		+"\n"+ "Sexo: " + contato.getSexo() + "\n" + "Idade: " + contato.getIdade());

   		try {
			FileOutputStream arq = new FileOutputStream("contato.arq");
			ObjectOutputStream obj = new ObjectOutputStream(arq);
			obj.writeObject(contato);
			obj.flush();
			
			JOptionPane.showConfirmDialog(null, "Gravação efetuada com sucesso");
   		
		} catch (Exception erro) {
			JOptionPane.showConfirmDialog(null, "Gravação não efetuada ");
		}
		
   		
   		try {
   			
   			FileInputStream arq = new FileInputStream("contato.arq");
			ObjectInputStream obj = new ObjectInputStream(arq);
			
			Contato contato1 = (Contato) obj.readObject();
			
			JOptionPane.showMessageDialog(null, "Nome: " + contato1.getNome() +"\n" + "Sobrenome " + contato1.getSobrenome() +"\n" + "E-mail " + contato1.getEmail() +"\n" + "Telefone " + contato1.getTelefone() 
	   		+"Sexo " + contato1.getSexo() + "\n " + "Idade" + contato1.getIdade());

   			
			
		} catch (Exception erro) {
			
			JOptionPane.showConfirmDialog(null, "Leitura não efetuada " + erro);
		}
   		
   		
   		
   		
   		
   		
	}
		
	}

