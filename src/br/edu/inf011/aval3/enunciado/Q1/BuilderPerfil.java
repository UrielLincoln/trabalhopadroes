package br.edu.inf011.aval3.enunciado.Q1;

import java.util.Iterator;
import java.util.List;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.Documento;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.enunciado.model.RG;


//Padrão builder utilizado para criar um perfil
public class BuilderPerfil {
	

	private List<Documento> documentos;
	private String nome;
	private String user;
	private String pwd;
	
	
	public BuilderPerfil(String nome) {
		this.nome = nome;
	}
	
	public BuilderPerfil user(String user) {
		this.user = user;
		return this;
	}
	
	public BuilderPerfil pwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	
	public BuilderPerfil documento(Documento documento) throws QuantidadeExcedida {
		if(documentos.size()<6)
			this.documentos.add(documento);
	 else {
        throw new QuantidadeExcedida("Limite máximo de documentos excedido.");
    }
		return this;
	}
	
	
	
	public Perfil construir() throws QuantidadeExcedida {
		verificarquantidade();
		if(this.pwd==null)
			this.pwd=this.nome;
		if(this.user==null)
			this.user=this.nome;
		return new Perfil(this);
	}

	
	
	
	//Verifica a quantidade de documentos para a criação da classe
	public void verificarquantidade() throws QuantidadeExcedida {
		int cc =0;
		int cpf =0;
		int rg =0;
		int email =0;
		
		Iterator<Documento> docs = this.getDocumentos().iterator();
		while(docs.hasNext()) {
			Documento doc = docs.next();
			if(doc.getClass().equals(CPF.class))
				cpf++;
			else if(doc.getClass().equals(CartaoCredito.class))
				cc++;
			else if(doc.getClass().equals(EMail.class))
				email++;
			else if(doc.getClass().equals(RG.class))
				rg++;
		}
		
		if (cpf > 1) {throw new QuantidadeExcedida("A quantidade de CPFs excedeu o limite permitido.");}
        if (cc > 2) {throw new QuantidadeExcedida("A quantidade de Cartões de Crédito excedeu o limite permitido.");}
        if (rg > 1) {throw new QuantidadeExcedida("A quantidade de RGs excedeu o limite permitido.");}
        if (email > 2) {throw new QuantidadeExcedida("A quantidade de E-mails excedeu o limite permitido.");}
		
	}
	
	
	
	
	public static class QuantidadeExcedida extends Exception {
	    public QuantidadeExcedida(String mensagem) {
	        super(mensagem);
	    }
	}
	
	
	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public String getNome() {
		return nome;
	}

	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}

}
