import javax.swing.text.Position;

public interface BinaryTree<E>extends Trees<E> {
    Positions<E> left(Positions<E> p) throws IllegalArgumentException;
    Positions<E>  right(Positions<E> p) throws IllegalArgumentException;
    Positions<E> sibling(Positions<E> p) throws IllegalArgumentException;
}
