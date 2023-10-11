package method;

public interface Check<T> {
    public boolean add(T t);

    public boolean increase(T t);

    public boolean decrease(T t);

    public T showHistory(T t);
}
