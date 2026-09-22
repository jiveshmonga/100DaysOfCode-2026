#include <stdio.h>

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    int queue[1000];
    int front = 0, rear = n - 1;

    // Create queue: 1, 2, 3, ..., n
    for (int i = 0; i < n; i++) {
        queue[i] = i + 1;
    }

    int minute = 0;

    while (front <= rear) {

        // Serve the person at the front
        int person = queue[front++];
        minute++;

        // If this is person k, print the minute
        if (person == k) {
            printf("%d\n", minute);
            break;
        }

        // Check the new front person
        if (front <= rear && queue[front] % 2 != 0) {
            // Move the odd person to the back
            int oddPerson = queue[front++];

            queue[++rear] = oddPerson;
        }
    }

    return 0;
}