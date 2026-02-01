package service.interfaces;

public interface Validatable<T> {
    void validate(T obj) throws Exception;

    default void validateNotNull(Object o, String msg) throws Exception {
        if (o == null) throw new Exception(msg);
    }

    static boolean notBlank(String s) {
        return s != null && !s.isBlank();
    }
}
