package se329.com.weight_lifting;

/**
 * Created by valbi_000 on 12/5/2016.
 */
public interface ServerResponseListener<T> {
    void getResult(T object);
}