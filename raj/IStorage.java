package raj;


// Immutable access to storage

public interface IStorage {
    Object  get( int idx );
    int     size();
}
