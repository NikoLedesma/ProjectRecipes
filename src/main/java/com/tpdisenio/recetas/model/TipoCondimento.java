package com.tpdisenio.recetas.model;

public enum TipoCondimento {
	 PICANTE("picante"), SALADO("salado"), DULCE("dulce"), AGRIDULCE("agridulce"), AGRIO("agrio");
	 
	 private String tipo;
	 
	 private TipoCondimento(String tipo) {
	   this.tipo = tipo;
	 }
	 
	 public String getCode() {
	   return this.tipo;
	 }
	 
}
