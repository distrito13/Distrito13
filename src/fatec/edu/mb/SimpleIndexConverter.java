package fatec.edu.mb;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


	@FacesConverter(value = "simpleIndexConverter")
	public class SimpleIndexConverter implements Converter {

		public Object getAsObject(FacesContext ctx, UIComponent component,
				String value) {
		System.out.println("getAsObject = " + value);
			if (value != null) {
				return this.getAttributesFrom(component).get(value);
			}
			return null;
		}

		public String getAsString(FacesContext ctx, UIComponent component,
				Object value) {
			System.out.println("getAsString = " + value);
			if (value != null && !"".equals(value)) {
				System.out.println("entrou");

				EntityGenerica entity = (EntityGenerica) value;

				// adiciona item como atributo do componente
				this.addAttribute(component, entity);

				int codigo = entity.getId();
				if (codigo != 0) {
					return String.valueOf(codigo);
				}
			}

			return (String) value;
		}

		protected void addAttribute(UIComponent component, EntityGenerica o) {
			System.out.println("addAttribute = " + o.getId());
			String key = Integer.toString(o.getId()); // codigo como chave neste caso
			this.getAttributesFrom(component).put(key, o);
		}

		protected Map<String, Object> getAttributesFrom(UIComponent component) {
			return component.getAttributes();
		}

	

}
