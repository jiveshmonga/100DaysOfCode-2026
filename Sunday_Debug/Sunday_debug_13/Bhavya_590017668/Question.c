#include <stdio.h>
#include <stdlib.h>

int main() {
    int weights[] = {4, 8, 2, 3, 6};
    int n = 5;
    int capacity = 10;

    // Sort crate weights in ascending order
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (weights[j] > weights[j + 1]) {
                int temp = weights[j];
                weights[j] = weights[j + 1];
                weights[j + 1] = temp;
            }
        }
    }

    int totalWeight = 0;
    int count = 0;
    int selected[5];

    // Greedy selection: choose lightest crates first
    for (int i = 0; i < n; i++) {
        if (totalWeight + weights[i] <= capacity) {
            selected[count] = weights[i];
            totalWeight += weights[i];
            count++;
        }
    }

    printf("Crates loaded: %d\n", count);

    printf("Selected crates: [");
    for (int i = 0; i < count; i++) {
        printf("%d", selected[i]);
        if (i < count - 1) {
            printf(", ");
        }
    }
    printf("]\n");

    printf("Total weight: %d\n", totalWeight);

    return 0;
}