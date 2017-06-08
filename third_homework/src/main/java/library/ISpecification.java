package library;

public interface ISpecification<T> {
	public boolean isSatisfiedBy(T entity);
}
