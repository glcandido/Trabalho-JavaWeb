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
@WebServlet("/CadastroImpressoraController")
public class CadastroImpressoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Guardando os valores solicitados em um vari�veis
			String paramMarca = request.getParameter("Marca");
			String paramModelo = request.getParameter("Modelo");
			String paramGarantia = request.getParameter("Garantia");
			String paramdt_Compra = request.getParameter("dt_Compra");
			
			// Gravando os valores obtidos na requisi��o.
			request.setAttribute("paramMarca", paramMarca);
			request.setAttribute("paramModelo", paramModelo);
			request.setAttribute("paramGarantia", paramGarantia);
			request.setAttribute("paramdt_Compra", paramdt_Compra);
			
			Long id = null;
			Date garantia = null;
			
			// Verifica��o e valida��o dos dados informados
			
			StringBuilder textoDaMensagem = new StringBuilder();
			
			if(paramMarca != null && !paramMarca.trim().equals("") && !paramMarca.equals("null")) {
				textoDaMensagem.append("A marca do computador n�o foi informada.").append("<br />");
			}
			
			if(paramModelo !=null && !paramModelo.trim().equals("") && !paramModelo.equals("null")) {
				textoDaMensagem.append("O modelo do computador n�o foi informado.").append("<br/>");
			}
			
			if(paramGarantia !=null && !paramGarantia.trim().equals("") && !paramGarantia.equals("null")) {
				textoDaMensagem.append("Informe at� quando o produto tem garantia.").append("<br/>");
			} else {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				format.setLenient(false);
				try {
					garantia = format.parse(paramGarantia);
				} catch (ParseException e) {
					textoDaMensagem.append("Data com formato inv�lido.").append("<br />");
				}
			}
			
			if(paramdt_Compra !=null && !paramdt_Compra.trim().equals("") && !paramdt_Compra.equals("null")) {
				textoDaMensagem.append("Informe a data da compra da impressora.").append("<br/>");
			} else {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				format.setLenient(false);
				try {
					garantia = format.parse(paramGarantia);
				} catch (ParseException e) {
					textoDaMensagem.append("Data com formato inv�lido.").append("<br />");
				}
			}
			
			Mensagem mensagem = new Mensagem(false,"Opera��o efetuada com sucesso.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Impressora.jsp").forward(request, response);
			
			// Tratamento de exce��o
		} catch (Exception e) {
			e.printStackTrace();
			Mensagem mensagem = new Mensagem(true, "Problemas ao salvar o equipamento.");
			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher("Impressora.jsp").forward(request, response);
		}
		
	}

}
