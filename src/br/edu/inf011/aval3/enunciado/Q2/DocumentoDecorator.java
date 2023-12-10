package br.edu.inf011.aval3.enunciado.Q2;

import br.edu.inf011.aval3.enunciado.model.Documento;


//Padr�o Decorator, para estender as fun�oes de uma classe sem alter�-la
public class DocumentoDecorator implements Documento {

	private Documento documento;
	
	public DocumentoDecorator(Documento documento) {
		this.documento = documento;
	}
		
	@Override
	public String formatar() {
		return documento.formatar();
	}

	@Override
	public boolean validar() {
		return documento.validar();
	}

	@Override
	public Integer pontuar() {
		return documento.pontuar();
	}
	
	public Integer calcularDias() {
		//Aqui seria a implementa��o do codigo do metodo para calcular os dias. N�o achei necessario colocar aqui, � s� um exemplo
		
		return 1;
	}
	

}
