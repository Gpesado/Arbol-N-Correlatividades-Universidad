package equivalencias;

public class Materia
{	
	private String nombre;
	
//******************************************************************************************************************************************************************************************************//
//																		CONSTRUCTORES																													//
//******************************************************************************************************************************************************************************************************//	
		public Materia(String nombre)
		{
			this.nombre=nombre;
		}		
	
//******************************************************************************************************************************************************************************************************//
//  																      GETTERS AND SETTER          																									//
//******************************************************************************************************************************************************************************************************//	
		public String getMateria() 
		{
			return nombre;
		}

		public void setMateria(String materia) 
		{
			this.nombre = materia;
		}
		
//******************************************************************************************************************************************************************************************************//
//																		 OVERRIDES/toString   							   																				//
//******************************************************************************************************************************************************************************************************//
	@Override
	public boolean equals(Object c)
	{
		if(c instanceof Materia)
		{	
			Materia m=(Materia)c;
			return this.getMateria().equals(m.getMateria());
		}
		else
		{
			return false;
		}
	}	
	
	@Override
	public String toString() 
	{
		return (String) nombre;
	}
}