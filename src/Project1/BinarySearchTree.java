package Project1;

import java.util.Queue;

/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 2, 2014
 * Description: A generic binary search tree class.
 *              Implements an unbalanced binary
 *              search tree.
 */

public class BinarySearchTree<T extends Comparable<? super T>>
{
    // The root of the tree.
    protected BinaryNode<T> root;

    /**
     * The constructor.
     * Sets the root to null.
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * Public insert method.
     * Inserts the passed element into the tree.
     * @param element - The element to be inserted.
     */
    public void insert(T element)
    {
        if(isEmpty())
            root = new BinaryNode<T>(element);
        else
            root = insert(root, element);
    }

    /**
     * Public remove method.
     * Removes the passed element from the tree.
     * @param element - The item to be removed.
     */
    public void remove(T element)
    {
        root = remove(root, element);
    }

    /**
     * Public removeMin method.
     * Removes the minimum element from the tree.
     */
    public void removeMin()
    {
        root = removeMin(root);
    }

    /**
     * Public findMin method.
     * Finds the minimum element in the tree.
     * @return - Returns the minimum element
     *           or null if the tree is empty.
     */
    public T findMin()
    {
        return elementAt(findMin(root));
    }

    /**
     * Public findMax method.
     * Finds the maximum element in the tree.
     * @return - Returns the maximum element
     *           or null if the tree is emtpy.
     */
    public T findMax()
    {
        return elementAt(findMax(root));
    }

    /**
     * Public find method.
     * Finds the passed element in the tree.
     * @param element - The element to search for.
     * @return - Returns the matching element or
     *           null if the element was not found.
     */
    public T find(T element)
    {
        return elementAt(find(root, element));
    }

    /**
     * Public makeEmpty method.
     * Makes the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }

    /**
     * Public isEmpty method.
     * Checks if the tree is logically empty.
     * @return - Returns true if the tree is empty,
     *           false if the tree is not empty.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Public contains method.
     * Checks if the tree contains the passed element.
     * @param element - The element to search for.
     * @return - Returns true if the element is in the
     *           tree, false if it is not in the tree.
     */
    public boolean contains(T element)
    {
        return (find(element) != null);
    }

    /**
     * Public search method.
     * Searches the tree for the passed element.
     * @param element - The element to search for.
     * @return - Returns true if the element is in the
     *           tree, false if it is not in the tree.
     */
    public boolean search(T element)
    {
        return search(root, element);
    }

    /**
     * Public traverseInOrder method.
     * Traverses the tree in order and prints out
     * a list of the elements in the tree.
     */
    public void traverseInOrder()
    {
        traverseInOrder(root);
    }

    /**
     * Public traversePreOrder method.
     * Traverses the tree in PreOrder and prints
     * out a list of the elements in the tree.
     */
    public void traversePreOrder()
    {
        traversePreOrder(root);
    }

    /**
     * Public traversePostOrder method.
     * Traverses the tree in PostOrder and prints
     * out a list of the elements in the tree.
     */
    public void traversePostOrder()
    {
        traversePostOrder(root);
    }

    /**
     * Public print method.
     * Prints out a formatted display of the tree.
     * Indentation is used to show nodes that are
     * at the same level.
     */
    public void print()
    {
        print(root, 0);
    }

    /**
     * Public list method.
     * Prints out an alphabetical list of the items
     * in the tree.
     */
    public void list()
    {
        traverseInOrder();
    }

    /**
     * Public getHeight method.
     * Returns the height of the tree.
     * @return - The height of the tree.
     */
    public int getHeight()
    {

        return 0;
    }

    /**
     *
     * @return
     */
    public int getNumberofNodes()
    {
        return 0;
    }

    public T getParent(T element)
    {
        return(elementAt(getParent(root, element, null)));
    }

    /**
     *
     */
    public T findSuccessor(T element)
    {
        return elementAt(findSuccessor(find(root, element)));
    }

    public T findPredecessor(T element)
    {
        return elementAt(findPredecessor(find(root, element)));
    }


    //====================================================//
    //                  INTERNAL METHODS                  //
    //====================================================//

    /**
     * Internal elementAt method.
     * Gets the element from the passed node.
     * @param node - The node to get the element from.
     * @return - Returns the node's element
     *           or null if the node is null.
     */
    private T elementAt(BinaryNode<T> node)
    {
        return (node == null) ? null : node.getElement();
    }

    /**
     * Internal insert method.
     * Inserts the passed element into a subtree.
     * @param element - The element to be inserted.
     * @param root - The node that roots the tree.
     * @return - Returns the new root.
     */
    protected BinaryNode<T> insert(BinaryNode<T> root, T element)
    {
        int comparison = element.compareTo(root.getElement());

        // Left child case.
        if(comparison < 0)
        {
            if(root.getLeftChild() != null)
                insert(root.getLeftChild(), element);
            else
                root.setLeftChild(new BinaryNode<T>(element));
        }

        // Right child case.
        else if(comparison > 0)
        {
            if(root.getRightChild() != null)
                insert(root.getRightChild(), element);
            else
                root.setRightChild(new BinaryNode<T>(element));
        }

        // Duplicate case.
        else
            System.out.println("ERROR: Element already exists.");

        return root;
    }

    /**
     * Internal remove method.
     * Removes the passed element from a subtree.
     * @param element - The element to be removed.
     * @param root - The node that roots the tree.
     * @return - Returns the root.
     */
    protected BinaryNode<T> remove(BinaryNode<T> root, T element)
    {
        if(root != null)
        {
            int comparison = element.compareTo(root.getElement());

            // Left child case.
            if(comparison < 0)
                root.setLeftChild(remove(root.getLeftChild(), element));

            // Right child case.
            else if(comparison > 0)
                root.setRightChild(remove(root.getRightChild(), element));

            // Two children case.
            else if(root.getLeftChild() != null && root.getRightChild() != null)
            {
                root.setElement(findMin(root.getRightChild()).getElement());
                root.setRightChild(removeMin(root.getRightChild()));
            }

            // Node found case.
            else
            {
                root = (root.getLeftChild() != null)
                        ? root.getLeftChild() : root.getRightChild();
            }
        }
        else
            System.out.println("ERROR: Element was not found.");

        return root;
    }

    /**
     * Internal removeMin method.
     * Removes the minimum element from a subtree.
     * @param root - The node that roots the tree.
     * @return - Returns the new root.
     */
    protected BinaryNode<T> removeMin(BinaryNode<T> root)
    {
        if(root == null)
        {
            System.out.println("ItemNotFound Exception: ");
            return null;
        }
        else if(root.getLeftChild() != null)
        {
            root.setLeftChild(removeMin(root.getLeftChild()));
            return root;
        }

        return root.getRightChild();
    }

    /**
     * Internal findMin method.
     * Finds the minimum element in a subtree.
     * @param root - The node that roots the tree.
     * @return - Returns the node containing the
     *           minimum element.
     */
    protected BinaryNode<T> findMin(BinaryNode<T> root)
    {
        if(root != null)
            while(root.getLeftChild() != null)
                root = root.getLeftChild();

        return root;
    }

    /**
     * Internal findMax method.
     * Finds the maximum element in a subtree.
     * @param root - The node that roots the tree.
     * @return - Returns the node containing
     *           the maximum element.
     */
    private BinaryNode<T> findMax(BinaryNode<T> root)
    {
        if(root != null)
            while(root.getRightChild() != null)
                root = root.getRightChild();

        return root;
    }

    /**
     * Internal find method.
     * Finds the passed element in a subtree.
     * @param element - The element to search for.
     * @param root - The node that roots the tree.
     * @return - Returns the node containing
     *           the element.
     */
    private BinaryNode<T> find(BinaryNode<T> root, T element)
    {
        while(root != null)
        {
            int comparison = element.compareTo(root.getElement());

            if(comparison < 0)
                root = root.getLeftChild();
            else if(comparison > 0)
                root = root.getRightChild();
            else
                return root;
        }

        return null;
    }

    /**
     * Internal search method.
     * Recursively searches the tree for the
     * passed element.
     * @param root - The node that roots the tree.
     * @param element - The element to search for.
     * @return - Returns true if the item is in
     *           the tree, false if it is not in
     *           the tree.
     */
    private boolean search(BinaryNode<T> root, T element)
    {
        if(root != null)
        {
            int comparison = element.compareTo(root.getElement());

            if (comparison < 0)
                return search(root.getLeftChild(), element);
            else if (comparison > 0)
                return search(root.getRightChild(), element);
            else
                // Item was found.
                return true;
        }

        // Item was not found.
        return false;
    }

    /**
     * Internal traverseInOrder method.
     * Recursively traverses the tree in order and
     * prints out a list of the elements.
     * @param root - The node that roots the tree.
     */
    private void traverseInOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
            traverseInOrder(root.getLeftChild());
            System.out.print(root.getElement().toString() + " ");
            traverseInOrder(root.getRightChild());
        }
    }

    /**
     * Internal traversePreOrder method.
     * Recursively traverses the tree in PreOrder
     * and prints out a list of the elements.
     * @param root - The node that roots the tree.
     */
    private void traversePreOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
            System.out.print(root.getElement().toString() + " ");
            traversePreOrder(root.getLeftChild());
            traversePreOrder(root.getRightChild());
        }
    }

    /**
     * Internal traversePostOrder method.
     * Recursively traverses the tree in PostOrder
     * and prints out a list of the elements.
     * @param root - The node that roots the tree.
     */
    private void traversePostOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
            traversePostOrder(root.getLeftChild());
            traversePostOrder(root.getRightChild());
            System.out.print(root.getElement().toString() + " ");
        }
    }

    /**
     * Internal traverseLevelOrder method.
     * Recursively traverses the tree in LevelOrder
     * and prints out a list of the elements.
     * @param root - The node that roots the tree.
     */
    private void traverseLevelOrder(BinaryNode<T> root)
    {
        if(root != null)
        {
        }
    }

    /**
     * Internal print method.
     * Prints out a formatted display of the tree.
     * Indentation is used to show nodes that are
     * at the same level.
     * @param root - The node that roots the tree.
     * @param indent
     */
    private void print(BinaryNode<T> root, int indent)
    {
        if(root != null)
        {
            String indentation = "";

            for(int i = 0; i < indent; i++)
                indentation += " ";

            System.out.println(indentation
                    + root.getElement().toString());

            indent += 5;

            print(root.getLeftChild(), indent);
            print(root.getRightChild(), indent);
        }
    }

    private BinaryNode<T> findSuccessor(BinaryNode<T> root)
    {
        if(root == null)
            return null;

        if(root.getRightChild() != null)
            return findMin(root.getRightChild());

        BinaryNode<T> y = getParent(this.root, root.getElement(), null);
        BinaryNode<T> x = root;

        while(y != null && x == y.getRightChild())
        {
            x = y;
            y = getParent(this.root, y.getElement(), null);
        }

        return y;
    }

    private BinaryNode<T> findPredecessor(BinaryNode<T> root)
    {
        if(root == null)
            return null;

        if(root.getLeftChild() != null)
            return findMax(root.getLeftChild());

        BinaryNode<T> y = getParent(this.root, root.getElement(), null);
        BinaryNode<T> x = root;

        while(y != null && x == y.getLeftChild())
        {
            x = y;
            y = getParent(this.root, y.getElement(), null);
        }

        return y;
    }

    private BinaryNode<T> getParent(BinaryNode<T> root, T element, BinaryNode<T> parent)
    {
        if(root == null)
            return null;
        else if(!(root.getElement() == element))
        {
            parent = getParent(root.getLeftChild(), element, root);

            if(parent == null)
                parent = getParent(root.getRightChild(), element, root);
        }

        return parent;
    }
}