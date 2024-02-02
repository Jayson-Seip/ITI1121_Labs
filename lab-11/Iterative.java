public class Iterative {

	public static BitList complement( BitList in ) {
		BitList b = new BitList();
		Iterator i = in.iterator();
		Iterator result = b.iterator();
		while(i.hasNext()){
			if(i.next() == 0){
				result.add(1);
			}
			else{
				result.add(0);
			}
		}
		return b;
	}

	public static BitList or( BitList a, BitList b ) {
		
		BitList or = new BitList();
		Iterator ia = a.iterator();
		Iterator ib = b.iterator();
		Iterator result = or.iterator();
		
		if(!ia.hasNext()|| !ib.hasNext()){
			throw new IllegalArgumentException();
		}
		while(ia.hasNext()){
			if(!ib.hasNext()){
				throw new IllegalArgumentException();
			}
			int bit1 = ia.next();
			int bit2 = ib.next();
			if(bit1==1 || bit2==1){
				result.add(1);
			}
			else{
				result.add(0);
			}
		}
		if(ib.hasNext()){
			throw new IllegalArgumentException();
		}
		return or;
	}

	public static BitList and( BitList a, BitList b ) {

		BitList and = new BitList();
		Iterator ia = a.iterator();
		Iterator ib = b.iterator();
		Iterator result = and.iterator();
		if(!ia.hasNext()|| !ib.hasNext()){
			throw new IllegalArgumentException();
		}
		while(ia.hasNext()){
			
			if(!ib.hasNext()){
				throw new IllegalArgumentException();
			}
			int bit1 = ia.next();
			int bit2 = ib.next();
			if(bit1==1 && bit2==1){
				result.add(1);
			}
			else{
				result.add(0);
			}
		}
		if(ib.hasNext()){
			throw new IllegalArgumentException();
		}
		return and;
	}

	public static BitList xor( BitList a, BitList b ) {

		BitList xor = new BitList();
		Iterator ia = a.iterator();
		Iterator ib = b.iterator();
		Iterator result = xor.iterator();
		if(!ia.hasNext()|| !ib.hasNext()){
			throw new IllegalArgumentException();
		}
		while(ia.hasNext()){
			if(!ib.hasNext()){
				throw new IllegalArgumentException();
			}
			int bit1 = ia.next();
			int bit2 = ib.next();
			if((bit1==1 && bit2==0) ||bit1==0 && bit2==1){
				result.add(1);
			}
			else{
				result.add(0);
			}
		}
		if(ib.hasNext()){
			throw new IllegalArgumentException();
		}
		return xor;
	}
}