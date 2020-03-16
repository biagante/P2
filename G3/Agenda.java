package pt.ua.prog2;

import pt.ua.prog2.Data;
import pt.ua.prog2.Tarefa;

import static java.lang.System.*;

public class Agenda {
	
	int numTarefas = 0; //contagem do numero de tarefas
	Tarefa[] tarefas = new Tarefa[1]; //array de tarefas
	
	public void novaTarefa(Tarefa tarefa)
	{
		Tarefa[] newTarefa = new Tarefa[numTarefas+1];
		arraycopy(tarefas, 0, newTarefa, 0, numTarefas);
		tarefas = newTarefa;
		tarefas[numTarefas] = tarefa;
		numTarefas++;
	}
	
	public void escreve()
	{
		//using ":" for iterating and displaying array elements iin a for loop
		out.println("Agenda: ");
		for (Tarefa tarefa : this.tarefas)
		{
			if (tarefa == null)
			{
				break;
			}
			else
			{
				out.println(tarefa.toString());
			}
		}	
	}
	
	public Agenda filtra(Data d1, Data d2)
	{
		Tarefa intr = new Tarefa(d1, d2, "");
		
		Agenda inter = new Agenda();
		
		for (Tarefa t : this.tarefas)
		{
			if (t == null)
			{
				break;
			}
			if (t.interseta(intr))
			{
				inter.novaTarefa(t);
			}
			else
			{
				continue;
			}
		}
		return inter;
	}
	
	
	
}

