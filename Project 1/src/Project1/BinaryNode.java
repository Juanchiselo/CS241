package Project1;

/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 2, 2014
 * Description: Generic BinaryNode class.
 *              These are the basic nodes stored
 *              in an unbalanced binary search tree.
 */

class BinaryNode<T>
{
    // The data in the node.
    private T element;

    // The left child of the node.
    private BinaryNode<T> leftChild;

    // The right child of the node.
    private BinaryNode<T> rightChild;


    /**
     * The constructor.
     * Sets the node's element to the element passed to it
     * when the node was instantiated.
     * @param element - The element to be stored inside the node.
     */
    public BinaryNode(T element)
    {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Element setter method.
     * Sets the node's element to the element passed to it.
     * @param element - The element to be stored inside the node.
     */
    public void setElement(T element)
    {
        this.element = element;
    }

    /**
     * Element getter method.
     * Gets the node's element.
     * @return - Returns the element stored inside the node.
     */
    public T getElement()
    {
        return element;
    }

    /**
     * Left child setter method.
     * Sets the node's left child to the node passed to it.
     * @param leftChild - The node that will be the left child
     *                    of this node.
     */
    public void setLeftChild(BinaryNode<T> leftChild)
    {
        this.leftChild = leftChild;
    }

    /**
     * Left child getter method.
     * Gets the node's left child.
     * @return - Returns the left child of the node.
     */
    public BinaryNode<T> getLeftChild()
    {
        return leftChild;
    }

    /**
     * Right child setter method.
     * Sets the node's right child to the node passed to it.
     * @param rightChild - The node that will be the right child
     *                     of this node.
     */
    public void setRightChild(BinaryNode<T> rightChild)
    {
        this.rightChild = rightChild;
    }

    /**
     * Right child getter method.
     * Gets the node's right child.
     * @return - Returns the right child of the node.
     */
    public BinaryNode<T> getRightChild()
    {
        return rightChild;
    }
}