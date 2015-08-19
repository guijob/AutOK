package com.pcs.autok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, 
      
      HttpServletResponse response,
      Object controller) throws Exception {

      String uri = request.getRequestURI();
      if(uri.endsWith("formularioLogin") || 
    		  uri.endsWith("logarUsuario") ||
    		  uri.endsWith("cadastrarCliente") ||
              uri.endsWith("formularioCadastrarCliente") ||
              uri.endsWith("/")){
        return true;
      }
      
      if(uri.contains("css") || uri.contains("fonts") || uri.contains("js")) {
    	  return true;
      }
      
      if(request.getSession().getAttribute("usuarioLogado") != null) {
        return true;
      }
      
      if(request.getSession().getAttribute("usuarioLogado") != null && uri.endsWith("/")) {
    	  response.sendRedirect("home");
          return true;
      }
      
      response.sendRedirect("formularioLogin");
      return false;
  }
	
}
