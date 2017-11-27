
class BinaryNode
{
    BinaryNode(Comparable theKey) {
        key = theKey;
        left = right = null;
    }

    Comparable key;          // datos del nodo
    BinaryNode left;         // hijo izquierdo
    BinaryNode right;        // hijo derecho
}
