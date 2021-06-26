package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		
	}

	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		//executa
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		
		System.out.println("tempo do " + acao + ": " + (depois - antes));
	}

}
