package equivalencias;
import java.util.ArrayList;

public class Carrera<T> extends ArbolN<T>
{	
	private String nombre;
	public ArrayList<T> materias; //implentarla con esto!
	
//******************************************************************************************************************************************************************************************************//
//																		CONSTRUCTORES																													//
//******************************************************************************************************************************************************************************************************//	
	public Carrera(String nombre)
	{
		super(0);
		this.nombre = nombre;
	}
	
//******************************************************************************************************************************************************************************************************//
//																			 FUNCIONES		        																									//
//******************************************************************************************************************************************************************************************************//
	private boolean matEnCarrera(T m)
	{
		return super.pertenece(m);
	}
	
	public void agregarMateria(T m)
	{
		if(!super.pertenece(m)) 
		{
			super.añadirNodo(m);
		}	
	}
	
	public void agregarCorrelatiblidad(T materia, T correlativa)
	{
		if (!matEnCarrera(materia) || !matEnCarrera(correlativa)) 
		{
			System.err.println("la materia no existe");
		}
		else
			{
				super.añadirNodoCorrelativo(materia, correlativa);
			}		
	}

	public T materiaConMasCorreltivas()
	{	
		return super.nodoConMayorNumeroDeNodosCorrelativos(); 
	}
	
	private boolean materiasIguales(ArrayList<NodoN<T>> lista)
	{
		for (int i = 0; i < lista.size(); i++) 
		{
			if(!this.matEnCarrera(lista.get(i).getDato())) return false;
		}
		return true;
	}
	
	private NodoN<T> auxBuscameNodo(T materia, ArrayList<NodoN<T>> lista )
	{
		for (int i = 0; i < lista.size(); i++) 
		{
			if(lista.get(i).getDato().equals(materia))
			{
				return lista.get(i);
			}			
		}
		return null;
	}
	
	private NodoN<T> buscameNodo(T materia)
	{
		return auxBuscameNodo(materia,this.raiz.getNodos());		
	}	
	
//******************************************************************************************************************************************************************************************************//
//																		 OVERRIDES/toString   							   																				//
//******************************************************************************************************************************************************************************************************//
	public String toString()
	{
		return this.nombre + "\n" + super.toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{  
		if (obj instanceof Carrera)			
		{
			Carrera c=(Carrera)obj;
			
			if(this.getCantHijos() != c.getCantHijos()) return false;
			
				if(!this.materiasIguales(c.getRaiz().getNodos())) return false;
			
					for (int i = 0; i < getCantHijos(); i++) 
					{
							if (!this.dameNodo(i).nodoIguales(c.buscameNodo(dameNodo(i).getDato()))) 
							{
								return false;
							}							
					}
			return true;
		}			
	return false;
	}	
}