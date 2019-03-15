import java.util.ArrayList;


public class Transactions {
    private double balance;
	
	ArrayList<String> a=new ArrayList<String>();
	ArrayList<String> b=new ArrayList<String>();
	public void add(double newbalance){
		
		balance=newbalance;
		
		
		if(a.size()>5){
			a.remove(0);
			
		}
		
		}
	
	public void	wthdrwl(double am){
		
		if(am>balance)
			am=0;
		balance -= am;
	add(balance);
	b.add(" ->withdraw");
	if(b.size()>5)
		b.remove(0);a.add(Double.toString(am));
	}
	public void	dpst(double am){
		
	
		
			balance += am;
			add(balance);
			b.add(" ->deposit");		
			if(b.size()>5)
				b.remove(0);
			a.add(Double.toString(am));
		}
	
	
	public double CurrentBalance(){
		return balance;
		
	}
	
		
public ArrayList<String> get_transactions(){
	
	return a;
}
public ArrayList<String> get_transactions2(){
	
	return b;
}
}
