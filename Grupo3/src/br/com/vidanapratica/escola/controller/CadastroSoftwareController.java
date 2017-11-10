package br.com.vidanapratica.escola.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vidanapratica.escola.helper.Mensagem;

/**
 * Servlet implementation class CadastroSoftwareController
 */
@WebServlet("/CadastroSoftwareController")
public class CadastroSoftwareController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Guardando os valores solicitados em um variáveis
			String paramId = request.getParameter("id");
			String paramNome = request.getParameter("Nome");
			String paramVersao = request.getParameter("Versao");
			String paramLicenca = request.getParameter("Licenca");
			
			// Gravando os valores obtidos na requisição.
			request.setAttribute("paramId", paramId);
			request.setAttribute("paramNome", paramNome);
			request.setAttribute("paramVersao", paramVersao);
			request.setAttribute("paramLicenca", paramLicenca);
			
			
			Long id = null;
			
			// Verificação e validação dos dados informados
			
			if(paramId != null && !paramId.trim().equals("") && !paramId.equals("null")){
				id = Long.valueOf(paramId);
			}
			
			StringBuilder textoDaMensagem = new StringBuilder();
			
			if(paramNome != null && !paramNome.trim().equals("") && !paramNome.equals("null")) {
				textoDaMensagem.append("Digite o nome do software.").append("<br />");
			}
			
			if(paramVersao !=null && !paramVersao.trim().equals("") && !paramVersao.equals("null")) {
				textoDaMensagem.append("Digite a versão do software.").append("<br/>");
			} 
			
			if(paramLicenca !=null && !paramLicenca.trim().equals("") && !paramLicenca.equals("null")) {
				textoDaMensagem.append("Digite o número de licença do software.").append("<br/>");
			} 
			
			Mensagem mensagem = new Mensagem(false,"Operação efetuada com sucesso.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Software.jsp").forward(request, response);
			
			// Tratamento de exceção
		} catch (Exception e) {
			e.printStackTrace();
			Mensagem mensagem = new Mensagem(true, "Problemas ao salvar o software.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Software.jsp").forward(request, response);
		}
	}

}
