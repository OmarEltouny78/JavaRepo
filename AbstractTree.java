import javax.swing.text.Position;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class AbstractTree<E>implements Trees<E> {
    @Override
    public int numChildren(Positions<E> p) throws IllegalArgumentException {
      int count=0;
      Queue<Positions>q=new LinkedList<>();
        List<Positions<E>> l=new LinkedList<>();
      q.add(root());
      while (!q.isEmpty()){
          Positions<E>node=q.peek();
          q.remove();
          for(int i=0;i<l.size();i++){
              Positions<E>children=l.get(i);
              count++;
              q.add(children);
          }
      }
      return count;
    }

    @Override
    public boolean isInternal(Positions<E> p) throws IllegalArgumentException {
        return numChildren(p)>0;
    }

    @Override
    public boolean isExternal(Positions<E> p) throws IllegalArgumentException {
        return numChildren(p)==0;
    }

    @Override
    public boolean isRoot(Positions<E> p) throws IllegalArgumentException {
        return p==root();
    }

    @Override
    public int size()
    {
        return size(root());
    }

    /* computes number of nodes in tree */
    public int size(Positions node)
    {
        node=root();
        if (node == null)
            return 0;
        else
            return numChildren(node)+1;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }
    public int depth(Positions<E> p) throws IllegalArgumentException {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }
    public int height(Positions<E>p)throws IllegalArgumentException {
        int h=0;
        p=root();
        for (Positions<E> positions:children(p)
             ) {

            h++;
        }
        return h;

    }



    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Positions<E>> positions() {
        return preorder();
    }
    private class ElementIterator implements Iterator<E> {
        Iterator<Positions<E>> posIterator = positions().iterator();
        public boolean hasNext() { return posIterator.hasNext(); }
        public E next() { return posIterator.next().getElement(); } // return element!
        public void remove() { posIterator.remove(); }
    }
    private List<Positions<E>> preorderSubtree(Positions<E> p, List<Positions<E>> snapshot) {
        if(p==null){
            return null;
        }for (Positions<E>ePositions:
                children(p)) {
            preorderSubtree(ePositions,snapshot);

        }
         snapshot.add(p);

        return snapshot;
    }

    public Iterable<Positions<E>> preorder() {
        Positions<E> p = root();
        List<Positions<E>> snapshot=new LinkedList<>();
        List<Positions<E>>a=preorderSubtree(p,snapshot);
        return (Iterable<Positions<E>>) snapshot.iterator();

    }

    private List<Positions<E>> postorderSubtree(Positions<E> p, List<Positions<E>> snapshot) {
        if(p==null){
            return null;
        }
        for (Positions<E>ePositions:
             children(p)) {
            postorderSubtree(ePositions,snapshot);

        }
        snapshot.add(p);

        return  snapshot;
    }

    public Iterable<Positions<E>> postorder() {
        Positions<E> p = root();
        List<Positions<E>> snapshot=new LinkedList<>();
        List<Positions<E>>a=postorderSubtree(p,snapshot);
        return (Iterable<Positions<E>>) snapshot.iterator();
    }


}
