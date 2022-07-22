/*
    Time Complexity: O(N)
    Space complexity: O(N)

    Where 'N' is the number of nodes.

 */

import java.util.List;
import java.util.ArrayList;

public class BSTiterator {

    static class BSTIterator {

        // Create a list to store node's value in sorted order
        List<Integer> nodeValues;

        // This will be used to iterate over the list
        int index;

        public BSTIterator(TreeNode<Integer> root) {
            nodeValues = new ArrayList<>();
            index = 0;

            // Fill the list with inorder traversal
            inorder(root);
        }

        public int next() {
            int nextSmallest = nodeValues.get(index);

            // Increment the index for next smallest element
            ++index;
            return nextSmallest;
        }

        public boolean hasNext() {

            // If index is less than size of the list that means there are still some nodes
            // left for processing
            if (index < nodeValues.size()) {
                return true;
            } else {
                return false;
            }
        }

        // This function will used to perform inorder traversal on the BST
        private void inorder(TreeNode<Integer> root) {
            if (root == null) {
                return;
            }

            // Traverse on the left child
            inorder(root.left);

            // Store the data
            nodeValues.add(root.data);

            // Traverse on the right child
            inorder(root.right);
        }

    }
}
