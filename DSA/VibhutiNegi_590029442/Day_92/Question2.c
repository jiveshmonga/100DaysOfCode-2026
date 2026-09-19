#include <stdio.h>
long long rob(int nums[], int n) {
    long long prev = 0;
    long long curr = 0;
    for (int i = 0; i < n; i++) {
        long long temp = curr;
        if (nums[i] + prev > curr)
            curr = nums[i] + prev;
        prev = temp;
    }
    return curr;
}
int main() {
    int n;
    scanf("%d", &n);
    int nums[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    printf("%lld", rob(nums, n));
    return 0;
}