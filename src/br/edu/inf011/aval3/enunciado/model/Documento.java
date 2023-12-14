package br.edu.inf011.aval3.enunciado.model;

import br.edu.inf011.aval3.enunciado.Q2.DocumentoVisitor;

public interface Documento {
	public String formatar();
	public boolean validar();
	public Integer pontuar();
	void accept(DocumentoVisitor visitor);
}
