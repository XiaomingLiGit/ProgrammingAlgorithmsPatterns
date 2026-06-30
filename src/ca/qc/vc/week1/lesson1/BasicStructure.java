package ca.qc.vc.week1.lesson1;

public class BasicStructure
{
    // fields with different access modifier (specifier)
    public char publicChar;              // visible everywhere
    protected float protectedFloat;      // visible to subclasses & same package
    double defaultDouble;                // package-private
    private int privateInt;              // visible only inside Example

    // methods with different access modifier (specifier)
    public void fn1() {}
    protected void fn2() {}
    void fn3() {}
    private void fn4() {}

    public static void main(String[] args)
    {

    }
}