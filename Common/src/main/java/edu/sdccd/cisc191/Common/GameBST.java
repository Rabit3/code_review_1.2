package edu.sdccd.cisc191.Common;

import edu.sdccd.cisc191.Common.Models.Game;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A utility class for constructing binary search trees (BSTs) of {@link Game} objects
 * based on various sorting criteria (ID, odds, date).
 */
public class GameBST {

    static class BSTNode<T> {
        T data;
        BSTNode<T> left, right;

        BSTNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
            // TODO: Check if data is null before setting it
        }
    }

    public static class BinarySearchTree<T> {
        private BSTNode<T> root;
        private final Comparator<T> comparator;

        public BinarySearchTree(Comparator<T> comparator) {
            this.comparator = comparator;
            // TODO: Add a check to make sure comparator is not null
        }

        public void insert(T data) {
            // TODO: Don't insert if data is null
            root = insertRecursive(root, data);
        }

        private BSTNode<T> insertRecursive(BSTNode<T> node, T data) {
            if (node == null) {
                return new BSTNode<>(data);
            }
            if (comparator.compare(data, node.data) < 0) {
                node.left = insertRecursive(node.left, data);
            } else {
                node.right = insertRecursive(node.right, data);
            }
            return node;
        }

        public List<T> inorderTraversal() {
            List<T> result = new ArrayList<>();
            inorderRecursive(root, result);
            return result;
        }

        private void inorderRecursive(BSTNode<T> node, List<T> list) {
            if (node != null) {
                inorderRecursive(node.left, list);
                list.add(node.data);
                inorderRecursive(node.right, list);
            }
        }
    }

    public static BinarySearchTree<Game> buildGameIdTree(List<Game> games) {
        // TODO: Check if games list is null before using it
        BinarySearchTree<Game> treeById = new BinarySearchTree<>(Comparator.comparing(Game::getId));
        games.forEach(treeById::insert);
        return treeById;
    }

    public static BinarySearchTree<Game> buildOddsTree(List<Game> games) {
        BinarySearchTree<Game> treeByOdds = new BinarySearchTree<>(Comparator.comparing(Game::getTeam1Odd));
        games.forEach(treeByOdds::insert);
        return treeByOdds;
    }

    public static BinarySearchTree<Game> buildTeam2OddsTree(List<Game> games) {
        BinarySearchTree<Game> treeByTeam2Odds = new BinarySearchTree<>(Comparator.comparing(Game::getTeam2Odd));
        games.forEach(treeByTeam2Odds::insert);
        return treeByTeam2Odds;
    }

    public static BinarySearchTree<Game> buildDateTree(List<Game> games) {
        // TODO: Handle games with missing or bad dates
        BinarySearchTree<Game> treeByDate = new BinarySearchTree<>(Comparator.comparing(Game::getGameDate));
        games.forEach(treeByDate::insert);
        return treeByDate;
    }
}
