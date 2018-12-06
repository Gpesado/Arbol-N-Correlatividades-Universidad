package equivalencias;

public class TestTp2c2 
{
	public static void main(String[] args) 
	{
		Carrera<Materia> c1 = new Carrera<Materia>("Licenciatura en Sistemas");
		Carrera<Materia> c2 = new Carrera<Materia>("Tecnicatura en Sistemas");

		Materia m1 = new Materia("Algoritmos I");
		Materia m2 = new Materia("Algoritmos II");
		
		c1.agregarMateria(m1);
		c1.agregarMateria(m2);

		c2.agregarMateria(m1);
		c2.agregarMateria(m2);

		c1.agregarCorrelatiblidad(m1, m2); // m1 es correlativa de m2
		c2.agregarCorrelatiblidad(m1, m2); // m1 es correlativa de m2
	
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c1.materiaConMasCorreltivas().toString());
		System.out.println(c2.materiaConMasCorreltivas().toString());
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c1));
	}
}