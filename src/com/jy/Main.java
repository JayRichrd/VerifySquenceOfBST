package com.jy;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] sequence1 = new int[] { 5, 7, 6, 9, 11, 10, 8 };
		int[] sequence2 = new int[] { 7, 4, 6, 5 };
		System.out.println("序列：" + Arrays.toString(sequence1) + "是否是某二叉搜索树的后序遍历序列："
				+ verifySequenceOfBST(sequence1, 0, sequence1.length - 1));
		System.out.println("序列：" + Arrays.toString(sequence2) + "是否是某二叉搜索树的后序遍历序列："
				+ verifySequenceOfBST(sequence2, 0, sequence2.length - 1));
	}

	/**
	 * 判定某序列是否是一棵二叉搜索树的后序遍历序列
	 * 
	 * @param sequence
	 *            待判定的序列
	 * @param start
	 *            判定的开始位置
	 * @param end
	 *            判定的结束位置
	 * @return 是则返回true,否则返回false
	 */
	public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
		if (sequence == null || (end - start + 1) <= 0)
			return false;
		// 最后一个元素是当前树的根节点
		int root = sequence[end];
		// 寻找左右子树的分界点
		// 左子树上的节点值都小于根节点，右子树上的节点值都大于根节点
		int i = start;
		for (; i < end; i++) {
			if (sequence[i] > root)
				break;
		}
		// 检查右子树的值是否都是大于根节点的值
		int j = i;
		for (; j < end; j++) {
			if (sequence[j] < root)
				return false;
		}
		// 递归判断左右子树
		boolean left = true;
		if (i > start)
			left = verifySequenceOfBST(sequence, start, i - 1);
		// 递归判断左右子树
		boolean right = true;
		if (i < end)
			right = verifySequenceOfBST(sequence, i, end - 1);

		return (left && right);
	}

}
