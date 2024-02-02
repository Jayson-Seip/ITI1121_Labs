public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        count = 0;
		elems  = new Pair[INITIAL_CAPACITY];
    }

    @Override
    public void put(String key, Integer value) {
		if(count == elems.length){
			increaseCapacity();
		}
        Pair p;
		p = new Pair(key,value);
		elems[count++] = p;
    }

    private void increaseCapacity() {
        Pair[] newElems = new Pair[elems.length + INCREMENT];
		for (int i=0; i< elems.length; i++) {
			newElems[i] = elems[i];
		}
		elems = newElems;
    }

    @Override
    public boolean contains(String key) {
        for(int i=0;i<count;i++){
			if(key.equals(elems[i].getKey())){
				return true;
			}
		}
		return false;
    }

    @Override
    public Integer get(String key) {
        for(int i=count-1;i>-1;i--){
			if(key.equals(elems[i].getKey())){
				return elems[i].getValue();
			}
		}
		return null;
    }

    @Override
    public void replace(String key, Integer value) {
        for (int i = count-1;i>-1;i--){
			if(key.equals(elems[i].getKey())){
				elems[i].setValue(value);
			}
		}

    }

    @Override
    public Integer remove(String key) {
        for(int i = count-1;i>-1;i--){
			if(key.equals(elems[i].getKey())){
				count--;
				return elems[i].getValue();
				
			}
		}
		return null;
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}