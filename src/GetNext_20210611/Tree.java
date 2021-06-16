package GetNext_20210611;

/**
 * @Author WangBei
 * @Date 2021/6/11 11:54
 */
public class Tree {

    TreeNode root = new TreeNode("a");
    TreeNode nodeB = new TreeNode("b");
    TreeNode nodeC = new TreeNode("c");
    TreeNode nodeD = new TreeNode("d");
    TreeNode nodeE = new TreeNode("e");
    TreeNode nodeF = new TreeNode("f");
    TreeNode nodeG = new TreeNode("g");
    TreeNode nodeH = new TreeNode("h");
    TreeNode nodeI = new TreeNode("i");

    Tree() {

        root.left = nodeB;
        root.right = nodeC;
        nodeB.parent = root;
        nodeC.parent = root;

        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeD.parent = nodeB;
        nodeE.parent = nodeB;

        nodeC.left = nodeF;
        nodeC.right = nodeG;
        nodeF.parent=nodeC;
        nodeG.parent=nodeC;

        nodeE.left = nodeH;
        nodeE.right = nodeI;
        nodeH.parent=nodeE;
        nodeI.parent=nodeE;

    }
}
