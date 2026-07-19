package ca.qc.vc.week1.lesson1;

public class LocalVar {

//    var name = "Tom";       // No: class field cannot declare as var

    // No: return value of method(memeber function cannot declare as var
//    public var getName() {
//        return "Tom";
//    }

    public void localVarExample() {
        var x = 10;        // OK
        var name = "Tom";  // OK

//        var y;             // NO: must be initialized immediately
//        var z = null;      // NO: cannot get data type info from null
    }
}
