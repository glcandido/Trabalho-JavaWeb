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

/**
 * Servlet implementation class CadastroComputadorController
 */
@WebServlet("/CadastroComputadorController")
public class CadastroMonitorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Guardando os valores solicitados em um variáveis
			String paramId = request.getParameter("id");
			String paramMarca = request.getParameter("Marca");
			String paramModelo = request.getParameter("Modelo");
			String paramGarantia = request.getParameter("Garantia");
			
			// Gravando os valores obtidos na requisição.
			request.setAttribute("paramId", paramId);
			request.setAttribute("paramMarca", paramMarca);
			request.setAttribute("paramModelo", paramModelo);
			request.setAttribute("paramGarantia", paramGarantia);
			
			Long id = null;
			Date garantia = null;
			
			// Verificação e validação dos dados informados
			
			if(paramId != null && !paramId.trim().equals("") && !paramId.equals("null")){
				id = Long.valueOf(paramId);
			}
			
			StringBuilder textoDaMensagem = new StringBuilder();
			
			if(paramMarca != null && !paramMarca.trim().equals("") && !paramMarca.equals("null")) {
				textoDaMensagem.append("A marca do computador não foi informada.").append("<br />");
			}
			
			if(paramModelo !=null && !paramModelo.trim().equals("") && !paramModelo.equals("null")) {
				textoDaMensagem.append("O modelo do computador não foi informado.").append("<br/>");
			}
			
			if(paramGarantia !=null && !paramGarantia.trim().equals("") && !paramGarantia.equals("null")) {
				textoDaMensagem.append("Informe até quando o produto tem garantia.").append("<br/>");
			} else {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				format.setLenient(false);
				try {
					garantia = format.parse(paramGarantia);
				} catch (ParseException e) {
					textoDaMensagem.append("Data com formato inválido.").append("<br />");
				}
			}
			
			Mensagem mensagem = new Mensagem(false,"Operação efetuada com sucesso.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Monitor.jsp").forward(request, response);
			
			// Tratamento de exceção
		} catch (Exception e) {
			e.printStackTrace();
			Mensagem mensagem = new Mensagem(true, "Problemas ao salvar o cliente.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Monitor.jsp").forward(request, response);
		}
		
	}

}
