package br.com.vidanapratica.escola.helper;


public final class Mensagem {
	
	private final boolean erro;
	private final String texto;
	
	public Mensagem(boolean erro, String texto) {
		super();
		this.erro = erro;
		this.texto = texto;
	}

	public boolean isErro() {
		return erro;
	}

	public String getTexto() {
		return texto;
	}
	
}
