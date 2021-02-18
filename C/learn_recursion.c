# include<stdio.h>

int sum(int *arr, int n)
{
    return n ==0 ? 0 : sum( arr, n-1) + arr[n-1];
}

int main(void)
{

    int arr[10] = {1,2,3,4,5,6,7,8,9,10};
    printf("%d\n", sum(arr, 10));

    return 0;
}

// 题目要求：不使用 for、while 求数组元素之和
