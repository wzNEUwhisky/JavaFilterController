package com.edu.neu.struts2.helloworld;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterDispatcher
 */
@WebFilter("*.action")
public class FilterDispatcher implements Filter {

    /**
     * Default constructor. 
     */
    public FilterDispatcher() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		//��ȡservletPath
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		String path = null;
		//�ж�servletPath,������ڡ�/product-input.action��,��ת����/WEB-INF/pages/input.jsp
		if("/product-input.action".equals(servletPath)) {
			path = "/WEB-INF/pages/input.jsp";
		}
		//�������"/product-save.action"����
		if("/product-save.action".equals(servletPath)) {
			//1).��ȡ�������
			String productName = request.getParameter("productName");
			String productDesc = request.getParameter("productDesc");
			String productPrice = request.getParameter("productPrice");
			//2).��������Ϣ��װΪһ��product����
			Product product = new Product(null,productName,productDesc,Double.parseDouble(productPrice));
			//3).ִ�б������
			System.out.println("Save product: " + product);
			product.setProductId(1001);
			//4).��product���󱣴浽request�� ${param.productName} -> ${requestScope.product.productName}
			request.setAttribute("product", product);
			
			path = "/WEB-INF/pages/details.jsp";
		}
		
		
		
		if(path != null) {
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
