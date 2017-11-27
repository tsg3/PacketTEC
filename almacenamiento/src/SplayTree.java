

public class SplayTree
{
    private BinaryNode root;

    public SplayTree() {
        root = null;
    }

    /**
     * insertar en el arbol
     * @param x parametro a meter
     * @throws DuplicateItemException si x ya está presente 
     */
    public void insert(Comparable key) {
	BinaryNode n;
	int c;
	if (root == null) {
	    root = new BinaryNode(key);
	    return;
	}
	splay(key);
	if ((c = key.compareTo(root.key)) == 0) {
	    //	    envia DuplicateItemException(x.toString());	    
	    return;
	}
	n = new BinaryNode(key);
	if (c < 0) {
	    n.left = root.left;
	    n.right = root;
	    root.left = null;
	} else {
	    n.right = root.right;
	    n.left = root;
	    root.right = null;
	}
	root = n;
    }

    /**
     * elimina del arbol
     * @param x parametro a meter.
     * @throws ItemNotFoundException si no encuentra x
     */
    public void remove(Comparable key) {
	BinaryNode x;
	splay(key);
	if (key.compareTo(root.key) != 0) {
	    //         envia ItemNotFoundException(x.toString());
	    return;
	}
	// ahora elimina la ruta
	if (root.left == null) {
	    root = root.right;
	} else {
	    x = root.right;
	    root = root.left;
	    splay(key);
	    root.right = x;
	}
    }

    /**
     * encuentra el menor objeto del arbol
     */
    public Comparable findMin() {
        BinaryNode x = root;
        if(root == null) return null;
        while(x.left != null) x = x.left;
        splay(x.key);
        return x.key;
    }

    /**
     * encuentra el objeto mas grande.
     */
    public Comparable findMax() {
        BinaryNode x = root;
        if(root == null) return null;
        while(x.right != null) x = x.right;
        splay(x.key);
        return x.key;
    }

    /**
     * encuentra objeto en arbol
     */
    public Comparable find(Comparable key) {
	if (root == null) return null;
	splay(key);
        if(root.key.compareTo(key) != 0) return null;
        return root.key;
    }

    /**
     * test para ver si el arbol esta vacio
     * @return true esta vacio y falso tiene objetos dentro 
     */
    public boolean isEmpty() {
        return root == null;
    }

    /** this method just illustrates the top-down method of
     * implementing the move-to-root operation 
     */
    private void moveToRoot(Comparable key) {
	BinaryNode l, r, t, y;
	l = r = header;
	t = root;
	header.left = header.right = null;
	for (;;) {
	    if (key.compareTo(t.key) < 0) {
		if (t.left == null) break;
		r.left = t;                                 /* link right */
		r = t;
		t = t.left;
	    } else if (key.compareTo(t.key) > 0) {
		if (t.right == null) break;
		l.right = t;                                /* link left */
		l = t;
		t = t.right;
	    } else {
		break;
	    }
	}
	l.right = t.left;                                   /* assemble */
	r.left = t.right;
	t.left = header.right;
	t.right = header.left;
	root = t;
    }

    private static BinaryNode header = new BinaryNode(null); // For splay
    
    /**
     * metodo interno para realizar top-down splay.
     */
     

    private void splay(Comparable key) {
	BinaryNode l, r, t, y;
	l = r = header;
	t = root;
	header.left = header.right = null;
	for (;;) {
	    if (key.compareTo(t.key) < 0) {
		if (t.left == null) break;
		if (key.compareTo(t.left.key) < 0) {
		    y = t.left;                            /* rotate right */
		    t.left = y.right;
		    y.right = t;
		    t = y;
		    if (t.left == null) break;
		}
		r.left = t;                                 /* link right */
		r = t;
		t = t.left;
	    } else if (key.compareTo(t.key) > 0) {
		if (t.right == null) break;
		if (key.compareTo(t.right.key) > 0) {
		    y = t.right;                            /* rotate left */
		    t.right = y.left;
		    y.left = t;
		    t = y;
		    if (t.right == null) break;
		}
		l.right = t;                                /* link left */
		l = t;
		t = t.right;
	    } else {
		break;
	    }
	}
	l.right = t.left;                                   /* assemble */
	r.left = t.right;
	t.left = header.right;
	t.right = header.left;
	root = t;
    }
}

