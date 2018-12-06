package equivalencias;
import java.util.ArrayList;

public class ArbolN<T> 
{
	Integer tMax;
	NodoN<T> raiz;
	T m;

//******************************************************************************************************************************************************************************************************//
//																		CONSTRUCTORES																													//
//******************************************************************************************************************************************************************************************************//	
	public ArbolN(Integer tMax)
	{
		this.tMax=tMax;
		raiz = (NodoN<T>) new NodoN<T>(m,tMax);
	}

//******************************************************************************************************************************************************************************************************//
//	                                                                     GETTERS AND SETTER          																									//
//******************************************************************************************************************************************************************************************************//	
	public NodoN<T> getRaiz() 
	{
		return raiz;
	}
	
	public Integer gettMax() 
	{
		return tMax;
	}
	
	public void settMax(Integer tMax) 
	{
		this.tMax = tMax;
	}
	
	public void setRaiz(NodoN<T> raiz) 
	{
		this.raiz = raiz;
	}
	
	public int getCantHijos()
	{
		return this.raiz.getNodos().size();
	}
	
	public NodoN<T> dameNodo(int posicion)
	{
		return raiz.getNodos().get(posicion);
	}
	
	public T dameDatoNodo(int posicion)
	{
		return dameNodo(posicion).getDato();
	}
	
//******************************************************************************************************************************************************************************************************//
//    													                   METODOS PARA AGREGAR				         																					//
//******************************************************************************************************************************************************************************************************//
	
	protected void añadirNodo(T dato)
	{
		NodoN<T> nuevo = new NodoN<T>(dato,tMax);
		nuevo.setDato(dato);
		raiz.agregar(nuevo);
		tMax++;
	}
	
	private void ayudanteAñadirNodoCorrelativo(NodoN<T> actualizar, NodoN<T> referencia) 
	{
		if (!referencia.nodos.isEmpty()) 
		{
			//TODO: ¿QUE TENDRIA QUE HACER ACA? -- NOTA AGREGADA EN 2018
		}
	}
	
	public void añadirNodoCorrelativo(T m1, T m2)
	{		
		if (buscarDato(m1).nodos.size() < tMax)
		{			
			NodoN<T> aux = buscarDato(m1); //busco m1 y lo pongo de correlativa a m1
			ayudanteAñadirNodoCorrelativo(aux,buscarDato(m1));
			buscarDato(m2).agregar(aux);
		}
		else
		{
			System.err.println("no se pudo agregar la correlativa");
		}		
	}
		
//******************************************************************************************************************************************************************************************************//
//   																		 FUNCIONES		        																									//
//******************************************************************************************************************************************************************************************************//
	public boolean pertenece(T e)
	{        			
		return raiz.Pertenece(e);
	}
		
	public NodoN<T> buscarDato(T m)
	{
		return this.raiz.buscarNodo(m);
	}
	
	public int contarNodosCorrelativos(ArrayList<T> lista)
	{
		return lista.size();
	}
	
	public T nodoConMayorNumeroDeNodosCorrelativos() 
	{		
		T materia = raiz.getDato(); //mando un puntero
		int numCorrelativas = -1 ;		
		
		if (!(getCantHijos() == 0));
		{			
			for (int i = 1; i < getCantHijos(); i++) 
			{
				ArrayList<T> correlativas = new ArrayList<T>();
				
				if (numCorrelativas < dameNodo(i).cantNodosCorrelativos()) 
				{
					numCorrelativas = dameNodo(i).cantNodosCorrelativos();
					materia = dameDatoNodo(i);
				}
			}
		}			
		return materia;
	}

//******************************************************************************************************************************************************************************************************//
//	 		 															 OVERRIDES/toString   							   																				//
//******************************************************************************************************************************************************************************************************//
	@Override
	public boolean equals(Object obj) 
	{
		boolean iguales=true;
		if (obj instanceof ArbolN)			
		{
			ArbolN c=(ArbolN)obj;
			int j;
			boolean esta=false;
			if (this.getCantHijos() != c.getCantHijos()) 
			{
				return false;
			}
			for (int i = 0; i < this.getCantHijos(); i++) 
			{
				for (int k = 0; k < c.getCantHijos(); k++) 
				{
				   
				}					
			}
		}		
		return false;		
	}
	
	public String toString()
	{
		return inOrder();
	}
	
	public String inOrder()
	{
		String msj = "........................................................................................ \n";
		for (int i = 0; i < getCantHijos(); i++) {
			msj += "\t " + dameDatoNodo(i).toString() + dameNodo(i).toString();
			msj += "\n";
			msj += "\n";
		}
		msj += "\n";
		return msj;
	}	
}