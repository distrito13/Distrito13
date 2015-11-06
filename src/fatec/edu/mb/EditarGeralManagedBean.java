package fatec.edu.mb;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EditarGeralManagedBean {

	public void direcionaEditarTomador() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("ConfiguracaoBuscarEditarTomador.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
