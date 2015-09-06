package fatec.edu.models;

import java.util.Date;

public class QuestionarioPtV {
		private int id;
		private Date dataAtraso;
		private String tipoPendencia;
		private float valor;
		private String periodo;
		private int idOrgao;
		private int idTomador;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDataAtraso() {
			return dataAtraso;
		}
		public void setDataAtraso(Date dataAtraso) {
			this.dataAtraso = dataAtraso;
		}
		public String getTipoPendencia() {
			return tipoPendencia;
		}
		public void setTipoPendencia(String tipoPendencia) {
			this.tipoPendencia = tipoPendencia;
		}
		public float getValor() {
			return valor;
		}
		public void setValor(float valor) {
			this.valor = valor;
		}
		public String getPeriodo() {
			return periodo;
		}
		public void setPeriodo(String periodo) {
			this.periodo = periodo;
		}
		public int getIdOrgao() {
			return idOrgao;
		}
		public void setIdOrgao(int idOrgao) {
			this.idOrgao = idOrgao;
		}
		public int getIdTomador() {
			return idTomador;
		}
		public void setIdTomador(int idTomador) {
			this.idTomador = idTomador;
		}
		
		
}
