package br.com.cadastro.main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import br.com.cadastro.model.Jogador;
import br.com.cadastro.negocio.JogadorImpl;

public class Principal {
	
	public static void main(String[] args) throws IOException {
       JogadorImpl jogImpl = new JogadorImpl();
       String enderecoDir = "files";
       String nomeArquivo = "jogadores.txt";
       if (!jogImpl.verificarArquivoExiste(Paths.get(enderecoDir))){
           System.out.println("Arquivo não encontrado");
       }
       else{            
    	   List<Jogador> listaDeJogadores = jogImpl.getListaDeJogadores(Paths.get(enderecoDir + "\\" + nomeArquivo));     
		   jogImpl.imprimirJogadorArtilheiro(listaDeJogadores);   
		   jogImpl.imprimirJogadorMaisVelho(listaDeJogadores); 
		   jogImpl.imprimirJogadorMaisNovo(listaDeJogadores);   
		}  
	 }

}
