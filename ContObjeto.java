import java.rmi.RemoteException;

public class ContObjeto implements Cont{
    private float value;

    public ContObjeto(float value){
        this.value = value;
    }
    public float getValue() {
        return value;
    }
    @Override
    public float nextValue() throws RemoteException {
        this.value = getValue() + 1;
        return getValue();
    }

}
