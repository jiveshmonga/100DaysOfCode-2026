#include <stdio.h>
#include <stdlib.h>

int* dailyTemperatures(int* temperatures, int temperaturesSize) {
    int *ans = calloc(temperaturesSize, sizeof(int));
    int *stack = malloc(temperaturesSize * sizeof(int));
    int top = -1;

    for (int i = 0; i < temperaturesSize; i++) {

        while (top >= 0 &&
               temperatures[i] > temperatures[stack[top]]) {

            int prev = stack[top--];
            ans[prev] = i - prev;
        }

        stack[++top] = i;
    }

    free(stack);
    return ans;
}

int main() {
    int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};
    int n = sizeof(temperatures) / sizeof(temperatures[0]);

    int *ans = dailyTemperatures(temperatures, n);

    printf("Output: ");

    for (int i = 0; i < n; i++)
        printf("%d ", ans[i]);

    printf("\n");

    free(ans);

    return 0;
}