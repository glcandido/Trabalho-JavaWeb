package br.com.vidanapratica.escola.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.vidanapratica.escola.helper.Mensagem;
import br.com.vidanapratica.escola.helper.CPF;

/**
 * Servlet implementation class CadastroComputadorController
 */
@WebServlet("/CadastroTecnicoController")
public class CadastroTecnicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Guardando os valores solicitados em um vari�veis
			String paramId = request.getParameter("id");
			String paramNome = request.getParameter("Nome");
			String paramCPF = request.getParameter("CPF");
			String paramdt_Nasc = request.getParameter("dt_Nasc");
			
			// Gravando os valores obtidos na requisi��o.
			request.setAttribute("paramId", paramId);
			request.setAttribute("paramNome", paramNome);
			request.setAttribute("paramCPF", paramCPF);
			request.setAttribute("paramdt_Nasc", paramdt_Nasc);
			
			Long cpfNumerico = null;
			Long id = null;
			Date garantia = null;
			
			// Verifica��o e valida��o dos dados informados
			
			if(paramId != null && !paramId.trim().equals("") && !paramId.equals("null")){
				id = Long.valueOf(paramId);
			}
			
			StringBuilder textoDaMensagem = new StringBuilder();
			
			if(paramNome != null && !paramNome.trim().equals("") && !paramNome.equals("null")) {
				textoDaMensagem.append("Digite o nome do t�cnico.").append("<br />");
			}
			
			if(paramCPF !=null && !paramCPF.trim().equals("") && !paramCPF.equals("null")) {
				textoDaMensagem.append("Digite o CPF do t�cnico.").append("<br/>");
			} else {
				try {
					cpfNumerico = Long.parseLong(paramCPF);
					CPF cpfOb = new CPF(cpfNumerico); // valida o CPF ao instanciar o objeto
					System.out.println("CPF com formatacao: "+cpfOb.getComFormatacao());
				} catch (Exception e) {
					textoDaMensagem.append("CPF com formato inv�lido.").append("<br />");
				}
			}
			
			if(paramdt_Nasc !=null && !paramdt_Nasc.trim().equals("") && !paramdt_Nasc.equals("null")) {
				textoDaMensagem.append("informe a data de nascimento.").append("<br/>");
			} else {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				format.setLenient(false);
				try {
					garantia = format.parse(paramdt_Nasc);
				} catch (ParseException e) {
					textoDaMensagem.append("Data com formato inv�lido.").append("<br />");
				}
			}
			
			Mensagem mensagem = new Mensagem(false,"Opera��o efetuada com sucesso.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Tecnico.jsp").forward(request, response);
			
			// Tratamento de exce��o
		} catch (Exception e) {
			e.printStackTrace();
			Mensagem mensagem = new Mensagem(true, "Problemas ao salvar o funcion�rio.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Tecnico.jsp").forward(request, response);
		}
		
	}

}
