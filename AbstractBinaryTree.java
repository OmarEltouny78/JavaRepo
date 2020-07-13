import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>{
    @Override
    public Positions<E> sibling(Positions<E> p) throws IllegalArgumentException {
       Positions<E> parent=parent(p);
       if(parent==null)return null;
       if(p==left(parent))
           return right(parent);
       else
           return left(parent);
    }
    public int numChildren(Positions<E> p){
        int count=0;
        if(left(p)!=null)
            count++;
        if(right(p)!=null)
            count++;
        return count;
    }
    public Iterable<Positions<E>>children(Positions<E> p){
        List<Positions<E>>snapshot=new ArrayList<>(2);
        if(left(p)!=null)
            snapshot.add(left(p));
        if(right(p)!=null)
            snapshot.add(right(p));
        return snapshot;
    }
    private List<Positions<E>> inorderSubTree(Positions<E>p,List<Positions<E>>snapshot){
        Stack<Positions<E>>positionsStack=new Stack<>();
        p=root();
        while (p!=null){
            positionsStack.push(p);
            p=left(p);
        }
        while(!positionsStack.isEmpty()){
            Positions<E>t=positionsStack.pop();
            snapshot.add(t);
            t=right(t);
            while (t!=null){
                positionsStack.push(t);
                t=left(t);
            }
        }
        return snapshot;


    }
    public Iterable<Positions<E>> inorder(){
        Positions<E> p = root();
        List<Positions<E>> snapshot=new LinkedList<>();
        List<Positions<E>>a=inorderSubTree(p,snapshot);
        return (Iterable<Positions<E>>) snapshot.iterator();

    }
    @Override
    public Iterable<Positions<E>> positions() {
        return inorder();
    }

}
