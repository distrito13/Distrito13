package fatec.edu.loginEmpresa;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ControleOfSession {

	public static <T> Object getObjectSession(String attribute) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession session = request.getSession(true);
		return session.getAttribute(attribute);
	}

}
