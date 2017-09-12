package util;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
	//a 空闲教室集合 m代表需要的教室数 ,num 表示学生数
	public ArrayList getGoodExamRooms(int[] a, int m, int num) {
		if (a.length < m) {
			return new ArrayList();
		}
		Algorithm zuhe = new Algorithm();
		List list = new ArrayList();
		int n = a.length;
		
		boolean flag = false; // 是否是最后一种组合的标记

		// 生成辅助数组。首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。
		int[] tempNum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i < m) {
				tempNum[i] = 1;

			} else {
				tempNum[i] = 0;
			}
			System.out.print(tempNum[i]);
		}
		print(tempNum);// 打印辅助数组

		list.add(zuhe.createResult(a, tempNum, m));// 打印第一中默认组合

		do {
			int pose = 0; // 记录改变的位置
			int sum = 0; // 记录改变位置 左侧 1 的个数
			// 然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为“01”
			for (int i = 0; i < (n - 1); i++) {
				if (tempNum[i] == 1 && tempNum[i + 1] == 0) {
					tempNum[i] = 0;
					tempNum[i + 1] = 1;
					pose = i;
					break;
				}
			}
			print(tempNum);// 打印辅助数组
			list.add(zuhe.createResult(a, tempNum, m));// 打印第一中默认组合

			// 同时将其左边的所有“1”全部移动到数组的最左端。

			for (int i = 0; i < pose; i++) {
				if (tempNum[i] == 1)
					sum++;
			}

			for (int i = 0; i < pose; i++) {
				if (i < sum)
					tempNum[i] = 1;
				else
					tempNum[i] = 0;
			}

			// 判断是否为最后一个组合：当第一个“1”移动到数组的m-n的位置，即n个“1”全部移动到最右端时，就得到了最后一个组合。
			flag = false;
			for (int i = n - m; i < n; i++) {

				if (tempNum[i] == 0)
					flag = true;

			}
		} while (flag);

		ArrayList<Integer> cSumList = new ArrayList<Integer>();
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[]) list.get(i);
			int sum = 0;
			System.out.println(temp);
			for (int j = 0; j < temp.length; j++) {
				System.out.println(temp[j]);
				sum += temp[j];
			}
			cSumList.add(sum);
		}
		System.out.println(cSumList);
		ArrayList<Integer> accList = new ArrayList<Integer>();
		for (int i = 0; i < cSumList.size(); i++) {
			if (cSumList.get(i) >= num) {
				accList.add(cSumList.get(i));
			}
		}
		int size = accList.size();
		int temp = 0;
		int j = 0;

		for (int i = 0; i < size; i++) {
			temp = accList.get(i);
			// 假如temp比前面的值小，则将前面的值后移
			for (j = i; j > 0 && temp < accList.get(j - 1); j--) {
				accList.set(j, accList.get(j - 1));
			}
			accList.set(j, temp);
		}
		System.out.println(accList);
		if (accList.isEmpty()) {
			return new ArrayList();
		} else {
			ArrayList returnList = new ArrayList();
			for (int k = 0; k < cSumList.size(); k++) {
				if (accList.get(0) == cSumList.get(k)) {
					index = k;
				}
			}

			int[] xuyao = (int[]) list.get(index);
			for (int i = 0; i < xuyao.length; i++) {
				returnList.add(xuyao[i]);
			}

			return returnList;
		}

	}

	// 根据辅助数组和原始数组生成 结果数组
	public int[] createResult(int[] a, int[] temp, int m) {
		int[] result = new int[m];
		int j = 0;
		for (int i = 0; i < a.length; i++) {

			if (temp[i] == 1) {
				result[j] = a[i];
				System.out.println("result[" + j + "]:" + result[j]);
				j++;

			}
		}
		return result;
	}

	// 打印
	public void print1(List list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			int[] temp = (int[]) list.get(i);
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp[j] + " ");
			}
		}
	}

	// 打印整数数组的方法
	public void print(int[] a) {
		System.out.println("生成的辅助数组为：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
