<p align="center">
    <a href="#">
		<img src="assets/Algorithm-in-Action-logo.png" width="280" alt="Algorithm in Action">
    </a>
</p>
<p align="center">
    <a href="./LICENSE">
		<img src="https://img.shields.io/github/license/Angus-Liu/Algorithm-in-Action.svg?style=popout-square" alt="license">
    </a>
    <a href="https://github.com/Angus-Liu/Algorithm-in-Action/search?l=java">
    	<img src="https://img.shields.io/github/languages/top/Angus-Liu/Algorithm-in-Action.svg?style=popout-square" alt="languages">
    </a>
    <a href="https://github.com/Angus-Liu/Algorithm-in-Action/commits">
    	<img src="https://img.shields.io/github/last-commit/Angus-Liu/Algorithm-in-Action.svg?style=popout-square" alt="last commit">
    </a>
	<a href="./LeetCode">
		<img src="https://img.shields.io/badge/LeetCode-251/1829-FDA116.svg?style=popout-square" alt="LeetCode">
	</a>
	<a href="./JianZhiOffer">
		<img src="https://img.shields.io/badge/剑指Offer-50/66-ff5959.svg?style=popout-square" alt="剑指Offer">
	</a>
</p>




# Algorithm in Action

> Some of my practices on Algorithms : ) 这个仓库保存着我在算法平台上的一些解答，代码中保留了必要的注释。不一定是最优的解答，但力保代码简洁易懂。后续还会整合其他题库，如若发现什么错误，希望你能告诉我或帮助我解决。非常感谢！

##  Catalog

- [Codewars](./Codewars)
- [LeetCode](./LeetCode)
- [剑指Offer](./Coding-Interviews)
- [程序员面试指南](./Programmer-Interview-Guide)

```java
/**
 * 快速排序
 */
public class QuickSort {
    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    private void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 切分
        int j = partition(arr, lo, hi);
        // 将左半部分 arr[lo, j-1] 排序
        sort(arr, lo, j - 1);
        // 将右半部分 arr[j+1, hi] 排序
        sort(arr, j + 1, hi);
    }

    /**
     * 将数组分为 arr[lo..i-1], arr[i], arr[i+1.. hi]
     */
    private int partition(Comparable[] arr, int lo, int hi) {
        // 随机在arr[lo...hi]的范围中, 选择一个数值作为标定点pivot，保证在数组近乎有序的情况下也能良好完成排序
        swap(arr, lo, (int) (Math.random() * (hi - lo + 1)) + lo);
        Comparable v = arr[lo];
        // 左右扫描指针
        int i = lo + 1;
        int j = hi;
        while (true) {
            // 扫描左右，检查是否结束并交换元素
            // 注意条件，减少等值元素的交换，防止算法时间复杂度退化为 O(n^2)
            while (i <= hi && arr[i].compareTo(v) <= 0) {
                i++;
            }
            while (j >= lo && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i >= j) {
                // 此时 j 一定指向的是小于或等于的元素
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable e = arr[i];
        arr[i] = arr[j];
        arr[j] = e;
    }
}
```

## LICENSE

```
MIT License

Copyright (c) 2018 Angus

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```