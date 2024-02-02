public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
		if(capacity<DEFAULT_INC){
			this.elems = (E[]) new Object[DEFAULT_INC];
		}
		else{
			        this.elems = (E[]) new Object[capacity];
		}

		this.top=0;
		
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
		if(isEmpty()){
			throw new java.util.EmptyStackException(); 
		}
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
		if(isEmpty()){
			throw new java.util.EmptyStackException(); 
		}
		if(top == DEFAULT_INC){
			E[] newArray;
			newArray = (E[]) new Object[top];
			for (int i=0; i<top; i++) {
				newArray[i] = elems[i];
			}
			elems = newArray;
		}
		E saved = elems[ --top ];

        elems[ top ] = null; // scrub the memory!
        return saved;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
		if(top == getCapacity()){// increase size
			E[] newArray;
			newArray = (E[]) new Object[ elems.length +DEFAULT_INC ];
			for (int i=0; i<top; i++) {
				newArray[i] = elems[i];
			}
	    elems = newArray;
	

		}
        elems[ top++ ] = element;
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        while(!isEmpty()){
			pop();
		}
		top=0;
    }

}