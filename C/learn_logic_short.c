# include<stdio.h>

int add(int n, int *sum)
{
    // 当 n-1 等于0时，形成逻辑短路，下面的条件式不执行，由此达到结束递归的目的
    n && add(n-1, sum);
    return *sum += n;
}

int main(void)
{
    int ret = 0;
    add(100, &ret);
    printf("%d\n", ret);

    return 0;
}

// 题目要求：计算 1+2+3+4+...+5+n 的和，不能使用 if、while、for、swith
// 解决思路：逻辑短路 + 递归
// 逻辑短路：
//    1） flase && ？ 时，？不计算
//    2） true || ? 时，？不计算
