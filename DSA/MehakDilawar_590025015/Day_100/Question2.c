//For each day's temperature, find how many days must pass before a strictly warmer temperature occurs, or return 0 if none exists.
//Input:temperatures=[73,74,75,71,69,72,76,73]. Output:1 1 4 2 1 1 0 0.
#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    scanf("%d", &n);
    int *temperatures = (int *)malloc(n * sizeof(int));
    int *answer = (int *)calloc(n, sizeof(int));
    int *stack = (int *)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        scanf("%d", &temperatures[i]);
    }
    int top = -1;
    for (int i = 0; i < n; i++) {
        while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
            int index = stack[top--];
            answer[index] = i - index;
        }
        stack[++top] = i;
    }
    for (int i = 0; i < n; i++) {
        printf("%d", answer[i]);
        if (i < n - 1)
            printf(" ");
    }
    printf("\n");
    free(temperatures);
    free(answer);
    free(stack);
return 0;
}