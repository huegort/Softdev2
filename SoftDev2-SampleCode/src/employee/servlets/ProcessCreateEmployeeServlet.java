package employee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.Employee;
import employee.EmployeeDAO;

/**
 * Servlet implementation class ProcessCreateEmployeeServlet
 */
@WebServlet("/ProcessCreateEmployeeServlet")
public class ProcessCreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessCreateEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			Employee employee = new Employee();
			employee.setId(Long.parseLong(request.getParameter("id")));
			employee.setName(request.getParameter("name"));
			EmployeeDAO employeeDAO = new EmployeeDAO();
			employeeDAO.create(employee);
			// no go to display all
			String view = "DisplayAllEmployeesServlet";
			request.getRequestDispatcher(view).forward(request, response);
		}catch(NumberFormatException nfe){
			response.getWriter().println("someone entered text instead of a number");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
