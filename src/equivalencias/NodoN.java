package equivalencias;
import java.util.ArrayList;

public class NodoN<T> 
{
	T dato;
	Integer tMax;
	ArrayList<NodoN<T>> nodos;
	
//******************************************************************************************************************************************************************************************************//
//																		CONSTRUCTORES																													//
//******************************************************************************************************************************************************************************************************//	
	public NodoN(T dato, Integer tMax)
	{
		this.dato = dato;
		this.tMax = tMax;
		nodos = new ArrayList<NodoN<T>>();
	}
	
//******************************************************************************************************************************************************************************************************//
//    																	GETTERS AND SETTER          																									//
//******************************************************************************************************************************************************************************************************//	
	
	public T getDato() 
	{
		return dato;
	}
	
	public void setDato(T dato) 
	{
		this.dato = dato;
	}
	
	public ArrayList<NodoN<T>> getNodos() 
	{
		return nodos;
	}
	
	public void setNodos(ArrayList<NodoN<T>> nodos) 
	{
		this.nodos = nodos;
	}
	
	public int cantNodosCorrelativos()
	{
		return cantidadNodosCorrelativos().size();
	}
 
//******************************************************************************************************************************************************************************************************//
// 																		   METODOS PARA AGREGAR				         																					//
//******************************************************************************************************************************************************************************************************//

	public void agregar(NodoN<T> nodo)
	{
			nodos.add(nodo);
			tMax++;		
	}
		
//******************************************************************************************************************************************************************************************************//
//																			 FUNCIONES		        																									//
//******************************************************************************************************************************************************************************************************//
	public NodoN<T> buscarNodo(T m1)
	{
		for (int i = 0; i < this.nodos.size(); i++) 
		{
			if (nodos.get(i).dato.equals(m1)) 
			{
				return nodos.get(i);
			}
		}
		return null;
	}
	
	public boolean nodoIguales(NodoN<T> nodo)
	{
		if (this.getNodos().size() != nodo.getNodos().size()) 
		{
			return false;
		}
		for (int i = 0; i < nodo.getNodos().size(); i++) 
		{
			if (!this.NodoEnLista(nodo.getNodos(), this.getNodos().get(i).getDato())) 
			{
				return false;
			}
		}
		return true;
		
	}
	
	public boolean Pertenece(T m1)
	{
		for (int i = 0; i < nodos.size(); i++)
		{	
			if (this.nodos.get(i).dato.equals(m1)) 
			{
				return true;
			}	
		}
		return false;
	}
	
	public ArrayList<T> cantidadNodosCorrelativos()
	{
		ArrayList<T> listaCorrelativas = new ArrayList<T>();
		this.cantidadNodosCorrelativos(listaCorrelativas);
		return listaCorrelativas;
	}
	
	private void cantidadNodosCorrelativos(ArrayList<T> listaCorrelativas)
	{
		for(int i = 0; i < this.getNodos().size(); i++)
		{
			if(!nodoEnLista(listaCorrelativas, nodos.get(i).getDato()))
			listaCorrelativas.add(nodos.get(i).getDato());
			if(nodos.get(i) != null) nodos.get(i).cantidadNodosCorrelativos(listaCorrelativas);
		}
	}
	
	public boolean nodoEnLista(ArrayList<T> lista, T dato)
	{
		for (int i = 0; i < lista.size(); i++) 
		{
			if(lista.get(i) == dato) return true; 
		}
		return false;
	}
	
	public boolean NodoEnLista(ArrayList<NodoN<T>> lista, T dato)
	{
		for (int i = 0; i < lista.size(); i++) 
		{
			if(lista.get(i).getDato() == dato) return true; 
		}
		return false;
	}	
	
//******************************************************************************************************************************************************************************************************//
//																		 OVERRIDES/toString   							   																				//
//******************************************************************************************************************************************************************************************************//

	@Override
	public String toString() 
	{
		ArrayList<T> lista = this.cantidadNodosCorrelativos();
		String msj = "";
		for (int i = 0; i < lista.size(); i++) 
		{
			msj += "\n \t \t ";
			msj += lista.get(i).toString();
			
			if(i != lista.size() - 1) msj += ", ";
		}
		return msj;
	}	
}