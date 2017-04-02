
public abstract class ArrayType {

    protected boolean bigArray;

    public ArrayType() {}

    public ArrayType(boolean bigArray) { this.bigArray = bigArray; }

    public abstract int[] getArray();

}
