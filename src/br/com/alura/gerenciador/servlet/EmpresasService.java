package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<Empresa> empresas = new Banco().getEmpresas();
    	
    	String valor = request.getHeader("Accept");
    	
    	if(valor.contains("json")) {
    		Gson gson = new Gson();
    		String json = gson.toJson(empresas); 
    		
    		response.setContentType("application/json");
    		response.getWriter().print(json);
    		
    	} else if(valor.contains("xml")) {
    		XStream xstream = new XStream();
    		xstream.alias("empresa", Empresa.class);
    		String xml = xstream.toXML(empresas); 
    		
    		response.setContentType("application/xml");
    		response.getWriter().print(xml);
    		
    	} else {
    		response.setContentType("application/json");
    		response.getWriter().print("{'message': 'no content'}");
    	}
    
    }

}
