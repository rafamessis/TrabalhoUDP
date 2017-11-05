
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            
            String saida;
            DatagramSocket socket = new DatagramSocket(1500);
            int texto=1,config=1;
            
            
            byte[] mensagem = new byte[300];
            DatagramPacket pacote = new DatagramPacket(mensagem,mensagem.length);
            byte[] mensagem1 = new byte[400];
            DatagramPacket pacoteConfiguracao = new DatagramPacket(mensagem1,mensagem1.length);
            //RECEBIMENTO DE PACOTE - OPERACAO BLOQUEANTE
            
            do{
                
                //saida = "";
                socket.receive(pacote);
                socket.receive(pacoteConfiguracao);
                saida = new String(pacote.getData(), 0, pacote.getLength());
                //System.out.println("Saida " + saida);
            
                System.out.println("Texto digitado: " + new String(pacote.getData(), 0, pacote.getLength()));
                System.out.println(new String(pacoteConfiguracao.getData(), 0, pacoteConfiguracao.getLength()));
                System.out.println("Remetente pacote 1: "+ pacote.getSocketAddress().toString());
                System.out.println("PORTA pacote 1: "+ pacote.getPort());
                System.out.println("Remetente pacote 2: "+ pacoteConfiguracao.getSocketAddress().toString());
                System.out.println("PORTA pacote 2: "+ pacoteConfiguracao.getPort());
                
                FileWriter arq2 = new FileWriter("C:\\Users\\Rafael\\Documents\\Faculdade\\8º Periodo\\Sistemas Distribuídos\\Trabalhos\\Trabalhos UDP\\Configuração" + String.valueOf(texto) + ".txt");
                PrintWriter gravarArq2 = new PrintWriter(arq2);
                gravarArq2.printf(new String(pacoteConfiguracao.getData(), 0, pacoteConfiguracao.getLength()));
                arq2.close();
                
                FileWriter arq = new FileWriter("C:\\Users\\Rafael\\Documents\\Faculdade\\8º Periodo\\Sistemas Distribuídos\\Trabalhos\\Trabalhos UDP\\Pacotes " + String.valueOf(texto) + ".txt");
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.printf(new String(pacote.getData(), 0, pacote.getLength()));
                arq.close();
                
                texto ++;
                
                
            }while (!(saida.equals("300")) );
            //socket.close();
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
