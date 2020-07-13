import javax.swing.text.Position;
import java.io.PipedOutputStream;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    protected static class Node<E> implements Positions<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }


    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    private Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    protected Node<E> validate(Positions<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not Valid position type");
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) throw new IllegalArgumentException("p is no longer in tree");
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    public Positions<E> root() {
        return root;
    }

    @Override
    public Positions<E> parent(Positions<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Positions<E> left(Positions<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    public Positions<E> right(Positions<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Positions<E> addRoot(E e) throws IllegalArgumentException {
        if (!isEmpty()) throw new IllegalArgumentException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Positions<E> addLeft(Positions<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) throw new IllegalArgumentException("Tree is not empty");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;

    }

    public Positions<E> addRight(Positions<E> p, E e) {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) throw new IllegalArgumentException("Tree is not empty");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Positions<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Positions<E> p, LinkedBinaryTree<E> t1,
                       LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) { // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }



    }
    public E remove(Positions<E> p) throws IllegalArgumentException {  Node<E> node = validate(p);
        if (numChildren(p) == 2)
          throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft( ) != null ? node.getLeft( ) : node.getRight( ) );
         if (child != null)
           child.setParent(node.getParent( ));
        if (node == root)
            root = child;
         else { Node<E> parent = node.getParent( );
            if (node == parent.getLeft( ))
              parent.setLeft(child);
            else
             parent.setRight(child);
            }  size--;
         E temp = node.getElement( );
        node.setElement(null);
       node.setLeft(null);
         node.setRight(null);
      node.setParent(node);
        return temp;
        }
}
