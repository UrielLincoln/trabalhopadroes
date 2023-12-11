package br.edu.inf011.aval3.enunciado.Q3;

import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.enunciado.model.service.Classificador;
import br.edu.inf011.aval3.enunciado.model.service.ClassificadorPerfil;
import br.edu.inf011.aval3.enunciado.model.service.NivelPerfil;

//Padrão utilizado: Proxy. Serve como intermediario para que se faça uma verificação de segurança do usuario e a senha do perfil, com uma informada
public class ProxyClassificador implements Classificador{

	private ClassificadorPerfil classificador;
	private String user;
	private String pwd;
	
	public ProxyClassificador(Perfil perfil, String user, String pwd) {
        this.classificador = new ClassificadorPerfil(perfil);
        this.user = user;
        this.pwd = pwd;
    }
	
	
	
	@Override
	public NivelPerfil nivel() {
		if (verificarCredenciais(this.user, this.pwd)) {
            return classificador.nivel();
        } else {
            return NivelPerfil.DESCONHECIDO;
        }
		
	}

	@Override
	public Perfil getPerfil() {
		// TODO Auto-generated method stub
		return classificador.getPerfil();
	}

	
	private boolean verificarCredenciais(String user, String pwd) {
		if(classificador.getPerfil().getUser().equals(user)&&classificador.getPerfil().getPwd().equals(pwd)) {
			return true;
		}
		else
			return false;
    }
	
	
	
}
