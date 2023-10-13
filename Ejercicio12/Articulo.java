package Ejercicio12;

public class Articulo {
	
	private String codigo;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int unidades;
	
	public Articulo(String codigo, String descripcion, double precioCompra, double precioVenta, int unidades) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.unidades = unidades;
	}
	
	public Articulo(String codigo) {
	    this.codigo = codigo;
	  }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Codigo: " + getCodigo() + "\nDescripcion: " + getDescripcion() +
				"\nPrecio de compra: " + getPrecioCompra() + "\nPrecio de venta: " + getPrecioVenta()
				+ "\nUnidades: " + getUnidades();	
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Articulo otro = (Articulo) obj;
	    return codigo.equals(otro.codigo);
	}
	
}
