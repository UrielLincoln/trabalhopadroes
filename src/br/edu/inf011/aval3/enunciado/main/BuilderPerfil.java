package br.edu.inf011.aval3.enunciado.main;

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
	
	public BuilderPerfil documento(Documento documento) {
		if(documentos.size()<6)
			this.documentos.add(documento);
	 else {
        throw new IllegalStateException("Limite máximo de documentos excedido.");
    }
		return this;
	}
	
	
	
	public Perfil construir() {
		if(this.pwd==null)
			this.pwd=this.nome;
		if(this.user==null)
			this.user=this.nome;
		return new Perfil(this);
	}

	
	
	
	//Verifica a quantidade de documentos para a criação da classe
	public void verificarquantidade() {
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
