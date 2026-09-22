#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int t[n], ans[n], stack[n], top = -1;

    for (int i = 0; i < n; i++)
        scanf("%d", &t[i]);

    for (int i = 0; i < n; i++) {
        while (top >= 0 && t[i] > t[stack[top]]) {
            int j = stack[top--];
            ans[j] = i - j;
        }
        stack[++top] = i;
    }

    while (top >= 0)
        ans[stack[top--]] = 0;

    for (int i = 0; i < n; i++)
        printf("%d ", ans[i]);

    return 0;
}
