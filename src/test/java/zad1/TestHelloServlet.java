package zad1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import servlet.HelloServlet;

public class TestHelloServlet extends Mockito {

	@Test
	public void server_should_not_greet_user_if_name_is_null() throws IOException{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HelloServlet servlet = new HelloServlet();
		
		when(request.getParameter("name")).thenReturn(null);
		
		servlet.doPost(request, response);
		
		verify(response).sendRedirect("/");	
	}
	
	@Test
	public void server_should_not_greet_user_if_name_is_empty() throws IOException{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HelloServlet servlet = new HelloServlet();
		
		when(request.getParameter("name")).thenReturn("");
		
		servlet.doPost(request, response);
		
		verify(response).sendRedirect("/");	
	}
	
	@Test
	public void server_should_greet_user_if_name_is_provided() throws IOException{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HelloServlet servlet = new HelloServlet();
		PrintWriter writer = mock(PrintWriter.class);

		when(request.getParameter("name")).thenReturn("jan");
		when(response.getWriter()).thenReturn(writer);
		
		servlet.doPost(request, response);
		
		verify(writer).println("<h1>Hello jan!</h1>");	
	}
}
