package Ejercicio12;

/*
 * 
Ejercicio 13
Modifica el programa Gestisimal realizado anteriormente añadiendo las siguientes mejoras:
• Utilizaunalistaenlugardeunarrayparaelalmacenamientodelosdatos.
• Comprueba la existencia del código en el alta, la baja y la modificación
de artículos para evitar errores.
• Cambia la opción “Salida de stock” por “Venta”. Esta nueva opción
permitirá hacer una venta de varios artículos y emitir la factura corres- pondiente. 
Se debe preguntar por los códigos y las cantidades de cada artículo que se quiere comprar. Aplica un 21% de IVA.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PruebaArticulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Articulo> articulo = new ArrayList<Articulo>();
		articulo.add(new Articulo("1","Boligrafo",1,2,20));
		articulo.add(new Articulo("2","Lapiz",1,2,20));
		HashMap <String,Integer> carrito = new HashMap<String,Integer>();
		
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		int i;
		int code = 0;
		double precioDeCompra = 0;
		double precioDeVenta = 0;
		int uni = 0;
		int unidadesEnFactura = 0;
		String codigo = "";
		String descripcion = "";
		String precioCompra = "";
		String precioVenta = "";
		String unidades = "";
		double sumaPrecio =0;
		double sumaTotal=0;
		double iva = 0.21;
		double ivaArticulo=0;
		double ivaSuma =0;
		
		do {
			System.out.println("1. Listado");
			System.out.println("2. Alta");
			System.out.println("3. Baja");
			System.out.println("4. Modificar");
			System.out.println("5. Entrada de mercancia");
			System.out.println("6. Venta");
			System.out.println("7. Salir");
			System.out.println("Elige una opcion");
			opcion = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcion) {
				case 1:
					for(Articulo a : articulo) {
						System.out.println(a);
						System.out.println();
					}
				break;
				case 2:
					System.out.println("Introduce los datos del articulo");
					System.out.print("Introduce el codigo: ");
					codigo = entrada.nextLine();
					if (articulo.contains(new Articulo(codigo))) {
			            System.out.print("Ese código ya existe.\nIntroduzca otro código: ");
			        }else {
			        	
			        	System.out.print("Descripcion: ");
			        	descripcion = entrada.nextLine();
			        	
			        	System.out.print("Precio de compra: ");
			        	precioDeCompra = Double.parseDouble(entrada.nextLine());
			        	
			        	System.out.print("Precio de venta: ");
			        	precioDeVenta = Double.parseDouble(entrada.nextLine());
			        	
			        	System.out.print("Stock: ");
			        	uni = Integer.parseInt(entrada.nextLine());
			        }	
					articulo.add(new Articulo(codigo, descripcion, precioDeCompra, precioDeVenta, uni));
				break;
				case 3:
					System.out.println("Introduce el codigo que quieres borrar");
					codigo = entrada.nextLine();
					if(!articulo.contains(new Articulo(codigo))){
						System.out.println("El no codigo existe, introduce otro");
					}else {
						articulo.remove(new Articulo(codigo));
						System.out.println("Articulo borrado");
					}
				break;
				case 4:
					System.out.println("Introduce el codigo que deseas modificar");
					codigo = entrada.nextLine();
					
					if(!articulo.contains(new Articulo(codigo))) {
						System.out.println("No existe este codigo");
					}
					else {
						
						i = articulo.indexOf(new Articulo(codigo));

						System.out.println("Introduzca los nuevos datos del artículo o INTRO para dejarlos igual.");
						System.out.println("Código: " + articulo.get(i).getCodigo());
			            System.out.print("Nuevo código: ");
			            codigo = entrada.nextLine();
			            if (!codigo.equals("")) {
			              articulo.get(i).setCodigo(codigo);
			            }
			            System.out.println("Descripción: " + articulo.get(i).getDescripcion());
			            System.out.print("Nueva descripción: ");
			            descripcion = entrada.nextLine();
			            if (!descripcion.equals("")) {
			              articulo.get(i).setDescripcion(descripcion);
			            }
			            
			            System.out.println("Precio de compra: " + articulo.get(i).getPrecioCompra());
			            System.out.print("Nuevo precio de compra: ");
			            precioCompra = entrada.nextLine();
			            if (!precioCompra.equals("")) {
			              articulo.get(i).setPrecioCompra(Double.parseDouble(precioCompra));
			            }
			            
			            System.out.println("Precio de venta: " + articulo.get(i).getPrecioVenta());
			            System.out.print("Nuevo precio de venta: ");
			            precioVenta = entrada.nextLine();
			            if (!precioVenta.equals("")) {
			              articulo.get(i).setPrecioVenta(Double.parseDouble(precioVenta));
			            }
			            
			            System.out.println("Stock: " + articulo.get(i).getUnidades());
			            System.out.print("Nuevo stock: ");
			            unidades = entrada.nextLine();
			            if (!entrada.equals("")) {
			              articulo.get(i).setUnidades(Integer.parseInt(unidades));
			            }
					}
				break;
				case 5:
					System.out.println("Introduzca el codigo del articulo");
					codigo = entrada.nextLine();
					if(!articulo.contains(new Articulo(codigo))) {
						System.out.println("El codigo no existe");
					}else {
						i = articulo.indexOf(new Articulo(codigo));
						System.out.println("Entrada de mercancia del siguiente articulo");
						System.out.println(articulo.get(i));
						System.out.println("Introduce el numero de unidades que han entrado");
						uni = Integer.parseInt(entrada.nextLine());
						articulo.get(i).setUnidades(uni + articulo.get(i).getUnidades());
						System.out.println("La mercancia ha entrado en el almacen");
					}
				break;
				case 6:
					
					do {
						System.out.println("1. Añadir al carrito");
						System.out.println("2. Sacar factura");
						System.out.println("3. Salir");
						System.out.println("Elige una opcion");
						opcion = entrada.nextInt();
						entrada.nextLine();
						switch(opcion) {
							case 1:
								System.out.println("Elige el codigo del articulo");
								codigo = entrada.nextLine();
								if(!articulo.contains(new Articulo(codigo))){
									System.out.println("No hay articulo con ese codigo");
								}else {
									
									i = articulo.indexOf(new Articulo(codigo));
									System.out.println("Elige las unidades");
									uni = entrada.nextInt();
									if((articulo.get(i).getUnidades()) < uni ) {
										System.out.println("No tenemos tantas unidades, el stock son " + articulo.get(i).getUnidades() + " unidades");
									}else {
										articulo.get(i).setUnidades(articulo.get(i).getUnidades() - uni);
										System.out.println("Se ha añadido el carrito:");
										System.err.println("Articulo: " + articulo.get(i).getDescripcion());
										System.out.println("Unidades: "+ uni);
										System.out.println("Precio por unidad : " + articulo.get(i).getPrecioVenta());
									}
									if(carrito.containsKey(codigo)){
										System.out.println("El codigo ya esta usado");
									}else {
										carrito.put(codigo, uni);
									}
								}
							break;
							case 2:
								System.out.println("Factura completa");
								for(String key : carrito.keySet()) {
									Integer value = carrito.get(key);
									i = articulo.indexOf(new Articulo(codigo));
									sumaPrecio = articulo.get(i).getPrecioVenta() * uni;
									ivaArticulo = sumaPrecio * iva;
									sumaTotal += sumaPrecio;
									System.out.println("Codigo: " + articulo.get(i).getCodigo());
									System.out.println("Descripcion: " + articulo.get(i).getDescripcion());
									System.out.println("Precio : " + articulo.get(i).getPrecioVenta());
									System.out.println("Unidades: " + value);
									System.out.println("Precio total : " + sumaTotal);
									System.out.println("Iva :" + ivaArticulo);
								}
						}
						double totalFinal = sumaTotal + ivaArticulo;
						System.out.println("Total a pargar:" + totalFinal);
						System.out.println();
					}while(opcion !=3);
			}
		}while(opcion != 7);
	}

}
