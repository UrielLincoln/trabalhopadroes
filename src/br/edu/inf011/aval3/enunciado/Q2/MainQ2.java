package br.edu.inf011.aval3.enunciado.Q2;

import br.edu.inf011.aval3.enunciado.model.*;



//Uso do padrão visitor para adicionar funções sem alterar a classe e subclasses de Documento
public class MainQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Documento email = new EMail("Exemplo@gmail.com");
		Documento cpf = new CPF("Fulano", "123456789");		
		DocumentoVisitor calcularDias = new CalcularDias();
		
		
		cpf.accept(calcularDias);
		email.accept(calcularDias);
	}

}
