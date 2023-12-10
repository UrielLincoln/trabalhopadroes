package br.edu.inf011.aval3.enunciado.Q2;

import br.edu.inf011.aval3.enunciado.model.Documento;


//Padrão Decorator, para estender as funçoes de uma classe sem alterá-la
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
		//Aqui seria a implementação do codigo do metodo para calcular os dias. Não achei necessario colocar aqui, é só um exemplo
		
		return 1;
	}
	

}
