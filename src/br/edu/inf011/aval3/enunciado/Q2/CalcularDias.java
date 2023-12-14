package br.edu.inf011.aval3.enunciado.Q2;

import br.edu.inf011.aval3.enunciado.model.Documento;
//Padrão visitor
public class CalcularDias implements DocumentoVisitor {

	@Override
	public void visit(Documento documento) {
		System.out.println("Os dias foram calculados!");
		
	}

}
