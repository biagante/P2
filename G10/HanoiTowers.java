import static java.lang.System.*;
import java.util.Scanner;
import p2utils.Stack;

/* 93418 - Beatriz Agante
 * 95288 - Lara Matos
 * 
 * */

public class HanoiTowers
{
	
	private int moves = 0;
	private Stack<Integer> TA;
	private Stack<Integer> TB;
	private Stack<Integer> TC;
	private int n;
	
	
	public HanoiTowers(int n)
	{
		TA = new Stack<Integer>();
		TB = new Stack<Integer>();
		TC = new Stack<Integer>();
		this.n = n;
		for (int i = n; i >= 1 ; i--)
		{
			putDisk(TA, i);
		}	
	}
	
	public void putDisk(Stack<Integer> origem, int disk)
	{
		origem.push(disk);
	}
	
	public void solve(){
		moveDiscs(n, TA, TC, TB);
	}
	
	public void printInfo(){
		
		out.printf("After %d moves: \n", moves);
		out.println("TA: " + TA.reverseToString());
		out.println("TB: " + TB.reverseToString());
		out.println("TC: " + TC.reverseToString() + "\n");
		
	}
	
	public void moveDiscs(int n, Stack<Integer> origem, Stack<Integer> destino, Stack<Integer> auxiliar)
	{
		assert n >= 0;
		if (n > 0)
		{
			moveDiscs(n - 1, origem, auxiliar, destino);
			moveOneDisc(origem, destino);
			printInfo();
			moveDiscs(n - 1, auxiliar, destino, origem);
		}
	}

	public void moveOneDisc(Stack<Integer> origem, Stack<Integer> destino)
	{
		moves++;		
		destino.push(origem.top());
		origem.pop();
	}
	
	public int numberOfMoves(){
		return moves;
	}
	

}
