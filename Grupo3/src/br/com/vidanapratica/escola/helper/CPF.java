package br.com.vidanapratica.escola.helper;

/**
 * Recebe um CPF formatado em String ou apenas numero com Long.
 * Valida e disponibiliza o CPF formatado como String, como String sem formata��o e contendo apenas n�meros. 
 * @author Inacio
 */
public class CPF {
	
	private final static int TAMANHO_COM_FORMATACAO = 14;
	private final static int TAMANHO_SEM_FORMATACAO = 11;
	
	private String comFormatacao;
	private String semFormatacao;
	private Long numerico;
	
	public CPF(String cpfFormatado){
		this.comFormatacao = cpfFormatado;
		validarVazioComFormatacao();
		validarTamanhoComFormatacao();
		retirarFormatacao();
		validarTamanhoSemFormatacao();
		converterEmNumerico();
		validar();
	}
	
	public CPF(Long numerico){
		this.numerico = numerico;
		validarVazioNumerico();
		converterEmSemFormatacao();
		formatar();
		validarTamanhoComFormatacao();
		validar();
	}
	
	private void validarVazioNumerico(){
		if (this.numerico == null || this.numerico.equals(0l)) {
			throw new IllegalArgumentException("CPF não informado.");
		}
	}
	
	private void validarVazioComFormatacao(){
		if (comFormatacao == null || comFormatacao.trim().equals("")) {
			throw new IllegalArgumentException("CPF não informado.");
		}
	}
	
	private void validarTamanhoComFormatacao(){
		if(this.comFormatacao.length() != TAMANHO_COM_FORMATACAO){
			throw new IllegalArgumentException("CPF "+this.comFormatacao+" com tamanho inválido");
		}
	}
	
	private void validarTamanhoSemFormatacao(){
		if(this.semFormatacao.length() != TAMANHO_SEM_FORMATACAO){
			throw new IllegalArgumentException("CPF "+this.semFormatacao+" com tamanho inválido");
		}
	}
	
	private void converterEmSemFormatacao(){
		this.semFormatacao = this.numerico.toString();
		if (this.semFormatacao.length() < 11){
			while (this.semFormatacao.length() < TAMANHO_SEM_FORMATACAO){
				this.semFormatacao = "0" + this.semFormatacao;
			}
		}
	}
	
	private void retirarFormatacao(){
		this.semFormatacao = this.comFormatacao.replaceAll("[.\\/\\-]", "");
	}
	
	private void converterEmNumerico(){
		try{
			this.numerico = Long.parseLong(this.semFormatacao);
		}catch (NumberFormatException e){
			throw new IllegalArgumentException("O CPF deve conter apenas números.");
		}
	}
		
	private void formatar(){
		this.comFormatacao = this.semFormatacao.substring(0,3) + "." + this.semFormatacao.substring(3,6) + "." + this.semFormatacao.substring(6,9) + "-" + this.semFormatacao.substring(9,11);
	}
		
	public void validar(){
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;	    
		
		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < this.semFormatacao.length() -1; nCount++)	{
			digitoCPF = Integer.valueOf (this.semFormatacao.substring(nCount -1, nCount)).intValue();		       
			d1 = d1 + ( 11 - nCount ) * digitoCPF;
			d2 = d2 + ( 12 - nCount ) * digitoCPF;
		}     

		resto = (d1 % 11);
		if (resto < 2){
			digito1 = 0;
		}else{
			digito1 = 11 - resto;
		}
		d2 += 2 * digito1;
		resto = (d2 % 11);
		if (resto < 2){
			digito2 = 0;
		}else{
			digito2 = 11 - resto;
		}
			
		String nDigVerific = this.semFormatacao.substring (this.semFormatacao.length()-2, this.semFormatacao.length());
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
			
		if(!nDigVerific.equals(nDigResult)){
			throw new IllegalArgumentException("Formato de CPF inválido.");
		}
	}
	
	public String getComFormatacao() {
		return comFormatacao;
	}

	public String getSemFormatacao() {
		return semFormatacao;
	}

	public Long getNumerico() {
		return numerico;
	}

	@Override
	public String toString() {
		return "CPF [comFormatacao=" + comFormatacao + ", semFormatacao="
				+ semFormatacao + ", numerico=" + numerico + "]";
	}

	
	public static void main(String[] args){
		CPF cpf = new CPF("070.237.978-66"); // OK
		//CPF cpf = new CPF(7023797866l); // OK
		
		
		// Testes com construtor Long -----------------------------------
		//CPF cpf = new CPF(117023797866l); // com tamanho invalido
		
		//CPF cpf = new CPF(797866l); // formato invalido
		
		//CPF cpf = new CPF(0l); // não informado
		// --------------------------------------------------------------
		
		//Testes com construtor String --------------------------------------
		//String teste = null;
		//CPF cpf = new CPF(teste);  // não informado
		
		//CPF cpf = new CPF("");  // não informado
		
		//CPF cpf = new CPF("07023797866"); // com tamanho inválido
		
		//CPF cpf = new CPF("0FF-66"); // com tamanho inválido
		
		//CPF cpf = new CPF("0FF.237.978-66"); // deve conter apenas números
		
		// -------------------------------------------------------------------
		System.out.println("CPF: "+cpf);
	}


}