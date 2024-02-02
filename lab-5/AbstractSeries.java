public abstract class AbstractSeries implements Series {

    public double[] take(int k) {
		double[] partial = new double[k];
        for(int i=0;i<k;i++){
			partial[i]=next();
		}
		return partial;
        
    }


}