/**
 * Implementing Sorting Algorithms
 *

 * @author     Oluwatosin Peters
 * @version    17/6/2016
 *
 * PURPOSE: This program implements a operations on a binary search tree
 *
 */

class BSTNode
{
    /**
     * The node class for the BST
     */
    private String data;
    private BSTNode left, right;
    int size;

    public BSTNode(String data)
    {
        /**
         * constructor
         */
        this.data = data;
        left = null;
        right = null;
    }

    public String getData()
    {
        /**
         * gets the data
         */
        return data;
    }

    public BSTNode leftChild()
    {
        /**
         * returns the left child
         */
        return left;
    }

    public BSTNode rightChild()
    {
        /**
         * returns the right child
         */
        return right;
    }


    public void setLeft(BSTNode left) {
        /**
         * sets the value for the left child
         */
        this.left = left;
    }

    public void setRight(BSTNode right)
    {
        /**
         * sets the value for the right child
         */
        this.right = right;
    }

    public boolean recursiveSearch(String item)
    {
        /**
         * recursive search algorithm that helps performs a search on the BST
         */
        boolean found = false;

        if (data.compareTo(item) == 0)
        {
            found = true;
        }else
        {
            if (item.compareTo(data) < 0)
            {
                if (left != null)
                {
                    found = left.recursiveSearch(item);
                }
            }else
            {
                if (right != null)
                {
                    found = right.recursiveSearch(item);
                }
            }
        }
        return found;
    }

    public void inOrder()
    {
        /**
         * A recursive method that helps perform a traversal on the BST
         */
        if (left != null)
        {
            left.inOrder();
        }
        System.out.println(data);
        if (right != null)
        {
            right.inOrder();
        }
    }

}


class BST
{
    /**
     * A BST class to create new object instances of the BST object
     */

    private BSTNode root;
    private int size;

    public BST()
    {
        /**
         * constructor
         */
        root = null;
    }

    public void insert(String theItem)
    {
        /**
         * inserts into the BST
         * @param theItem The string item to be inserted
         */
        if (root == null)
        {
            root = new BSTNode(theItem);
            size++;

        }
        else
        {
            BSTNode prev = null;
            BSTNode curr = root;
            boolean found = false;

            while(curr != null && !found)
            {
                prev = curr;
                if (theItem.compareTo(curr.getData()) < 0)
                {
                    curr = curr.leftChild();
                }else if(theItem.compareTo(curr.getData()) == 0)
                {
                    found = true;
                }else
                {
                    curr = curr.rightChild();
                }
            }

            if (!found)
            {
                if (theItem.compareTo(prev.getData()) < 0)
                {
                    //prev.left = new BSTNode(theItem);
                    prev.setLeft(new BSTNode(theItem));
                    size++;
                }
                else
                {
                    prev.setRight(new BSTNode(theItem));
                    size++;
                }
            }
        }
    }

    public int getSize()
    {
        /**
         * gets the size of the BST
         */
        return size;
    }


    public boolean search(String item)
    {
        /**
         * searches for a specific item in the tree
         * @param theItem The string item to be searched for
         *
         */
        boolean found = false;

        if (root != null)
        {
            found = root.recursiveSearch(item);
        }

        return found;
    }

    public void inOrder()
    {
        /**
         * performs an inorder traversal of the tree
         */
        if (root == null)
        {
            System.out.println("The tree is empty");
        }else
        {
            root.inOrder();
        }
    }

    public int height()
    {
        /**
         * returns the height of the tree
         */
        return height(root);
    }

    private int height(BSTNode node)
    {
        /**
         * private recursive method to return the height of the tree
         */
        if ( node == null )
        {
            return -1;
        }
        return 1 + Math.max(height(node.leftChild()), height(node.rightChild()));
    }

}