package br.edu.inf011.aval3.enunciado.Q2;

import br.edu.inf011.aval3.enunciado.model.*;



//Uso do decorator para adicionar funções sem alterar a classe e subclasses de Documento
public class MainQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Documento cpf = new EMail("Exemplo@gmail.com");
		
		DocumentoDecorator calcularDias = new DocumentoDecorator(cpf);
		
		calcularDias.calcularDias();
		
	}

}
