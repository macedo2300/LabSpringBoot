package com.br.vms.projeto.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.vms.projeto.model.Login;


@WebFilter("*.html")
public class AutenticacaoFilter implements Filter {
	
	Login usuarioLogado;
	
	public AutenticacaoFilter() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		HttpSession httpSession 				= ((HttpServletRequest) request).getSession(); 
		 
		HttpServletRequest httpServletRequest   = (HttpServletRequest) request;
 
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
 
	
		
		usuarioLogado = (Login) httpSession.getAttribute("usuarioAutenticado");
		
			if ((usuarioLogado == null && !httpServletRequest.getRequestURI().endsWith("/login.xhtml")) || 
					(usuarioLogado != null && !usuarioLogado.isLogado()
				&& !httpServletRequest.getRequestURI().endsWith("/login.xhtml"))) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");
				} else {
					chain.doFilter(request, response);
				}
			
		
	}

}
